package com.example.demo.views.Admin;

import com.example.demo.services.*;
import com.example.demo.util.UTILS;
import com.example.demo.views.components.ScheduleGrid;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.security.AuthenticationContext;
import jakarta.annotation.security.RolesAllowed;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Route(value = "/admin/schedule", layout = AdminLayout.class)
@RolesAllowed("ADMIN")
public class AdminScheduleView extends VerticalLayout {

    private final transient AuthenticationContext authenticationContext;
    private final TeamsService teamsService;
    private final AgesService agesService;
    private final GamesService gamesService;
    private final SeasonsService seasonsService;
    private final LocationsService locationsService;
    //Update sessions as needed
    List<LocalDate> sessions = new ArrayList<>();


    public AdminScheduleView(AuthenticationContext authenticationContext, TeamsService teamsService, AgesService agesService, GamesService gamesService, SeasonsService seasonsService, LocationsService locationsService){

        this.authenticationContext = authenticationContext;
        this.teamsService = teamsService;
        this.agesService = agesService;
        this.gamesService = gamesService;
        this.seasonsService = seasonsService;
        this.locationsService = locationsService;

        ScheduleGrid schedule = new ScheduleGrid(authenticationContext, teamsService, agesService, gamesService, seasonsService, locationsService);
        add(schedule, new Text("hello"));
    }




}
