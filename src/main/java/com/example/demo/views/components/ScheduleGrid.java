package com.example.demo.views.components;

import com.example.demo.services.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.security.AuthenticationContext;

public class ScheduleGrid extends VerticalLayout {

    private final transient AuthenticationContext authenticationContext;
    private final TeamsService teamsService;
    private final AgesService agesService;
    private final GamesService gamesService;
    private final SeasonsService seasonsService;
    private final LocationsService locationsService;


    public ScheduleGrid(AuthenticationContext authenticationContext, TeamsService teamsService, AgesService agesService, GamesService gamesService, SeasonsService seasonsService, LocationsService locationsService) {
        this.authenticationContext = authenticationContext;
        this.teamsService = teamsService;
        this.agesService = agesService;
        this.gamesService = gamesService;
        this.seasonsService = seasonsService;
        this.locationsService = locationsService;

        

    }
}
