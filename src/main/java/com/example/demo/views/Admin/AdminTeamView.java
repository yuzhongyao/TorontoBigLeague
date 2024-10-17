package com.example.demo.views.Admin;

import com.example.demo.entities.*;
import com.example.demo.services.*;
import com.example.demo.util.UTILS;
import com.example.demo.views.components.TeamStandingsGrid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.security.AuthenticationContext;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.time.Duration;
import java.util.List;

@Route(value = "/admin/team", layout = AdminLayout.class)
@RolesAllowed("ADMIN")
public class AdminTeamView extends VerticalLayout {
    private final transient AuthenticationContext authenticationContext;
    private final TeamsService teamsService;
    private final AgesService agesService;
    private final GamesService gamesService;
    private final SeasonsService seasonsService;
    private final SessionsService sessionsService;

    private final LocationsService locationsService;

    @Autowired
    public AdminTeamView(AuthenticationContext authenticationContext, TeamsService teamsService, AgesService agesService, GamesService gamesService
            , SeasonsService seasonsService, SessionsService sessionsService, LocationsService locationsService){
        this.authenticationContext = authenticationContext;
        this.teamsService = teamsService;
        this.agesService = agesService;
        this.gamesService = gamesService;
        this.seasonsService = seasonsService;
        this.sessionsService = sessionsService;
        this.locationsService = locationsService;

        this.setAlignSelf(Alignment.CENTER);
        this.setAlignItems(Alignment.CENTER);


        add(new TeamStandingsGrid( authenticationContext,  teamsService,  agesService,  gamesService
                ,  seasonsService,  sessionsService,  locationsService));

        Button addTeam = new Button("Add Team");
        addTeam.addClickListener(click -> {
            com.vaadin.flow.component.dialog.Dialog editor = new Dialog();
            editor.setHeaderTitle("Add Team");

            VerticalLayout editorLayout = new VerticalLayout();

            ComboBox<Age> age = new ComboBox<>("Age Group");
            age.setItems(agesService.getAll());
            age.setItemLabelGenerator(Age::getAge_group);
            age.setRequired(true);

            com.vaadin.flow.component.textfield.TextField teamName = new TextField("Team Name");
            teamName.setRequired(true);

            Button add = new Button("Add");
            add.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
            add.addClickListener(addClick -> {
                Team team = new Team();
                team.setTeam_name(teamName.getValue());
                team.setAge(age.getValue());

                this.teamsService.save(team);
                editor.close();
                UTILS.showNotification(new Notification(),"SUCCESSFULLY SAVED", true);

            });
            editorLayout.add(age,teamName);

            editor.add(editorLayout);
            editor.getFooter().add(add);
            editor.open();
        });

        add(addTeam);



    }





}
