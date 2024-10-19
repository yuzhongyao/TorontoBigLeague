package com.example.demo.views.Admin;

import com.example.demo.entities.*;
import com.example.demo.services.*;
import com.example.demo.util.UTILS;
import com.example.demo.views.components.ScheduleGrid;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.security.AuthenticationContext;
import jakarta.annotation.security.RolesAllowed;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Route(value = "/admin/schedule", layout = AdminLayout.class)
@RolesAllowed("ADMIN")
public class AdminScheduleView extends VerticalLayout {

    private final transient AuthenticationContext authenticationContext;
    private final TeamsService teamsService;
    private final AgesService agesService;
    private final GamesService gamesService;
    private final SeasonsService seasonsService;
    private final SessionsService sessionsService;

    private final LocationsService locationsService;
    //Update sessions as needed
    List<LocalDate> sessions = new ArrayList<>();


    public AdminScheduleView(AuthenticationContext authenticationContext, TeamsService teamsService, AgesService agesService, GamesService gamesService,
                             SeasonsService seasonsService, SessionsService sessionsService, LocationsService locationsService){

        this.authenticationContext = authenticationContext;
        this.teamsService = teamsService;
        this.agesService = agesService;
        this.gamesService = gamesService;
        this.seasonsService = seasonsService;
        this.sessionsService = sessionsService;
        this.locationsService = locationsService;

        ScheduleGrid schedule = new ScheduleGrid(authenticationContext, teamsService, agesService, gamesService, seasonsService, locationsService);

        Button addGame = new Button("ADD");
        addGame.addClickListener(click -> {
            Dialog editor = new Dialog();
            editor.setHeaderTitle("Add Game");

            VerticalLayout editorLayout = new VerticalLayout();

            ComboBox<Age> age = new ComboBox<>("Age Group");
            age.setItems(agesService.getAll());
            age.setItemLabelGenerator(Age::getAge_group);
            age.setRequired(true);


            ComboBox<Team> away = new ComboBox<>("Away Team");
            away.setItemLabelGenerator(Team::getTeam_name);
            away.setRequired(true);


            ComboBox<Team> home = new ComboBox<>("Home Team");
            home.setItemLabelGenerator(Team::getTeam_name);
            home.setRequired(true);

            ComboBox<Session> sessionComboBox = new ComboBox<>("Session");
            sessionComboBox.setRequired(true);
            sessionComboBox.setItems(sessionsService.getSessions());
            sessionComboBox.setItemLabelGenerator(Session::toString);


            age.addValueChangeListener(l -> {
                if (Objects.equals(l.getValue().getAge_group(), "Sr")   ){
                    List<Team> teams = teamsService.findAllSenior();
                    away.setItems(teams);
                    home.setItems(teams);
                    away.setItemLabelGenerator(Team::getTeamNameAndAge);
                    home.setItemLabelGenerator(Team::getTeamNameAndAge);
                    sessionComboBox.setItems(sessionsService.getSessionsByAge(l.getValue()));


                }
                else if( Objects.equals(l.getValue().getAge_group(), "Jr")){
                    List<Team> teams = teamsService.findAllJunior();
                    away.setItems(teams);
                    home.setItems(teams);
                    away.setItemLabelGenerator(Team::getTeamNameAndAge);
                    home.setItemLabelGenerator(Team::getTeamNameAndAge);
                    sessionComboBox.setItems(sessionsService.getSessionsByAge(l.getValue()));

                }

                else {
                    List<Team> teams = teamsService.findAllByAgeGroup(age.getValue());
                    away.setItems(teams);
                    home.setItems(teams);

                    sessionComboBox.setItems(sessionsService.getSessionsByAge(age.getValue()));
                }
            });

            DatePicker date = new DatePicker("Date");
            date.setRequired(true);

            TimePicker time = new TimePicker("Time");
            time.setStep(Duration.ofMinutes(5));
            time.setRequired(true);

            ComboBox<Location> location = new ComboBox<>("Location");
            location.setItems(locationsService.findAll());
            location.setItemLabelGenerator(Location::getLocation_name);
            location.setRequired(true);

            editorLayout.add(age, away, home, sessionComboBox, date, time, location);

            Button add = new Button("Add");
            add.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
            add.addClickListener(addClick -> {
                Game game = new Game();
                game.setAge_id(age.getValue());
                game.setLocation_id(location.getValue());
                game.setGame_date(date.getValue());
                game.setGame_time(time.getValue());
                game.setAway_id(away.getValue());
                game.setHome_id(home.getValue());
                game.setSeason(seasonsService.getCurrent());
                game.setSession_id(sessionComboBox.getValue());
                gamesService.save(game);
                editor.close();
                UTILS.showNotification(new Notification(),"SUCCESSFULLY SAVED", true);

            });

            editor.add(editorLayout);
            editor.getFooter().add(add);
            editor.open();

        });


        add(schedule,addGame);
    }




}
