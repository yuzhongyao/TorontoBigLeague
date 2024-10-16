package com.example.demo.views;

import com.example.demo.services.*;
import com.example.demo.views.components.TeamStandingsGrid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.security.AuthenticationContext;

@PageTitle("Team Standings | Toronto Big League")
@Route(value = "/standings", layout = MainLayout.class)
@AnonymousAllowed
public class Standings extends VerticalLayout {

    private final transient AuthenticationContext authenticationContext;
    private final TeamsService teamsService;
    private final AgesService agesService;
    private final GamesService gamesService;
    private final SeasonsService seasonsService;
    private final SessionsService sessionsService;

    private final LocationsService locationsService;


    public Standings(AuthenticationContext authenticationContext, TeamsService teamsService, AgesService agesService, GamesService gamesService, SeasonsService seasonsService, SessionsService sessionsService, LocationsService locationsService) {
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

    }

}
