package com.example.demo.views.Admin;

import com.example.demo.entities.*;
import com.example.demo.services.*;
import com.example.demo.util.UTILS;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.security.AuthenticationContext;
import jakarta.annotation.security.RolesAllowed;


@Route(value = "/admin", layout = AdminLayout.class)
@RolesAllowed("ADMIN")
public class AdminView  extends VerticalLayout {


    private final transient AuthenticationContext authenticationContext;
    private final TeamsService teamsService;
    private final AgesService agesService;
    private final GamesService gamesService;
    private final SeasonsService seasonsService;
    private final SessionsService sessionsService;
    private final LocationsService locationsService;



    public AdminView(AuthenticationContext authenticationContext, TeamsService teamsService, AgesService agesService, GamesService gamesService
    , SeasonsService seasonsService,  SessionsService sessionsService, LocationsService locationsService){
        this.authenticationContext = authenticationContext;

        this.teamsService = teamsService;
        this.agesService = agesService;
        this.gamesService = gamesService;
        this.seasonsService = seasonsService;
        this.sessionsService = sessionsService;
        this.locationsService = locationsService;
        this.setAlignSelf(Alignment.CENTER);
        this.setAlignItems(Alignment.CENTER);


        
        Button addAge = new Button("Add Age");
        addAge.addClickListener(click -> {
            Dialog dialog = new Dialog("Add Age");
            VerticalLayout editor = new VerticalLayout();
            editor.setAlignItems(Alignment.CENTER);
            editor.setAlignSelf(Alignment.CENTER);

            TextField ageField = new TextField("Age Group");
            ageField.setRequired(true);
            Button save = new Button("Save");
            save.addClickListener(c -> {
                if(!ageField.isEmpty()) {
                    Age age = new Age();
                    age.setAge_group(ageField.getValue());
                    agesService.save(age);
                    UTILS.showNotification(new Notification(), "SUCCESSFULLY SAVED", true);
                    dialog.close();
                }
                else {
                    UTILS.showNotification(new Notification(), "PLEASE FILL ALL FIELDS" ,false);
                }
            });
            editor.add(ageField);

            dialog.add(editor);
            dialog.getFooter().add(save);
            dialog.open();
        });

        Button addLocation = new Button("Add Location");
        addLocation.addClickListener(click -> {
            Dialog dialog = new Dialog("Add Age");
            VerticalLayout editor = new VerticalLayout();
            editor.setAlignItems(Alignment.CENTER);
            editor.setAlignSelf(Alignment.CENTER);

            TextField name = new TextField("Location Name");
            name.setRequired(true);
            TextField address = new TextField("Location Address");
            address.setRequired(true);

            Button save = new Button("Save");
            save.addClickListener(c -> {
                if(!name.isEmpty() && !address.isEmpty()) {
                    Location location = new Location();
                    location.setLocation_name(name.getValue());
                    location.setLocation_address(address.getValue());

                    locationsService.save(location);
                    UTILS.showNotification(new Notification(), "SUCCESSFULLY SAVED", true);
                    dialog.close();
                }
                else {
                    UTILS.showNotification(new Notification(), "PLEASE FILL ALL FIELDS" ,false);
                }
            });

            editor.add(name,address);

            dialog.add(editor);
            dialog.getFooter().add(save);
            dialog.open();
        });

        Button addSession = new Button("Add Session");
        addSession.addClickListener(cl ->{
            Dialog dialog = new Dialog("Add Age");
            VerticalLayout editor = new VerticalLayout();
            editor.setAlignItems(Alignment.CENTER);
            editor.setAlignSelf(Alignment.CENTER);

            ComboBox<Age> age = new ComboBox<>("Ages");
            age.setItemLabelGenerator(Age::getAge_group);
            age.setItems(agesService.getAll());
            age.setRequired(true);

            DatePicker date = new DatePicker("Session Date");
            date.setRequired(true);

            ComboBox<Season> season = new ComboBox<>("Season");
            season.setItemLabelGenerator(Season::getSeason_name);
            season.setRequired(true);
            season.setItems(seasonsService.getCurrent());

            Button save = new Button("Save");
            save.addClickListener(c -> {
                if(!age.isEmpty() && !date.isEmpty() && !season.isEmpty()) {
                    Session session = new Session();
                    session.setSession_date(date.getValue());
                    session.setAge(age.getValue());
                    session.setSeason(season.getValue());

                    sessionsService.save(session);
                    UTILS.showNotification(new Notification(), "SUCCESSFULLY SAVED", true);
                    dialog.close();
                }
                else {
                    UTILS.showNotification(new Notification(), "PLEASE FILL ALL FIELDS" ,false);
                }
            });

            editor.add(age,date,season);

            dialog.add(editor);
            dialog.getFooter().add(save);
            dialog.open();
        });

        Button addSeason = new Button("Add Season");
        addSeason.addClickListener(cli -> {
                    Dialog dialog = new Dialog("Add Age");
                    VerticalLayout editor = new VerticalLayout();
                    editor.setAlignItems(Alignment.CENTER);
                    editor.setAlignSelf(Alignment.CENTER);

                    TextField s = new TextField("Season Name");
                    s.setRequired(true);

                    Button save = new Button("Save");
                    save.addClickListener(c -> {
                        if (!s.isEmpty()) {
                            Season season = new Season();
                            season.setSeason_name(s.getValue());

                            seasonsService.save(season);
                            UTILS.showNotification(new Notification(), "SUCCESSFULLY SAVED", true);
                            dialog.close();
                        } else {
                            UTILS.showNotification(new Notification(), "PLEASE FILL ALL FIELDS", false);
                        }
                    });

            editor.add(s);

            dialog.add(editor);
            dialog.getFooter().add(save);
            dialog.open();
                });


        add(addAge,addLocation,addSeason, addSession);


    }



}
