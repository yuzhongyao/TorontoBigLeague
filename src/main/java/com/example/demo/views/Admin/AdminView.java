package com.example.demo.views.Admin;

import com.example.demo.entities.Team;
import com.example.demo.services.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;


@Route("admin")
@RolesAllowed("ADMIN")
public class AdminView extends VerticalLayout {


    private final TeamsService teamsService;
    private final AgesService agesService;
    private final GamesService gamesService;
    private final SeasonsService seasonsService;
    private final LocationsService locationsService;

    public AdminView(TeamsService teamsService, AgesService agesService, GamesService gamesService
    , SeasonsService seasonsService, LocationsService locationsService){

        this.teamsService = teamsService;
        this. agesService = agesService;
        this.gamesService = gamesService;
        this.seasonsService = seasonsService;
        this.locationsService = locationsService;


        

    }


}
