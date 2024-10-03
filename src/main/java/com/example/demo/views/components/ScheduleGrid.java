package com.example.demo.views.components;

import com.example.demo.entities.Game;
import com.example.demo.services.*;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.TabSheetVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.spring.security.AuthenticationContext;

public class ScheduleGrid extends VerticalLayout {

    private final transient AuthenticationContext authenticationContext;
    private final TeamsService teamsService;
    private final AgesService agesService;
    private final GamesService gamesService;
    private final SeasonsService seasonsService;
    private final LocationsService locationsService;

    Grid<Game> middleSchoolGames = new Grid<>(Game.class, false);
    Grid<Game> jrGames = new Grid<>(Game.class, false);
    Grid<Game> srGames = new Grid<>(Game.class, false);
    public ScheduleGrid(AuthenticationContext authenticationContext, TeamsService teamsService, AgesService agesService, GamesService gamesService, SeasonsService seasonsService, LocationsService locationsService) {
        this.authenticationContext = authenticationContext;
        this.teamsService = teamsService;
        this.agesService = agesService;
        this.gamesService = gamesService;
        this.seasonsService = seasonsService;
        this.locationsService = locationsService;

        this.setAlignSelf(Alignment.CENTER);
        this.setAlignItems(Alignment.CENTER);
        TabSheet tabSheet = new TabSheet();

        configureGrid(middleSchoolGames);
        configureGrid(jrGames);
        configureGrid(srGames);

        Tab grade8 = new Tab("Grade 8");


        Tab jr = new Tab("Grade 9/10 | Jr Prep");


        Tab sr = new Tab("Grade 11/12 | Sr Prep");



        tabSheet.add(grade8,middleSchoolGames);
        tabSheet.add(jr,jrGames);
        tabSheet.add(sr,srGames);

        tabSheet.addThemeVariants(TabSheetVariant.LUMO_TABS_CENTERED);
        tabSheet.setWidthFull();
        add(tabSheet);

    }

    private void configureGrid(Grid<Game> grid){
        grid.addColumn(game -> game.getGame_date()).setHeader("Date");
        grid.addColumn(game -> game.getGame_time()).setHeader("Time");
        grid.addColumn(game -> game.getAway_id().getTeam_name()).setHeader("Away");
        grid.addColumn(Game::getAway_pts).setHeader("Away Pts");
        grid.addColumn(game -> game.getHome_id().getTeam_name()).setHeader("Home");
        grid.addColumn(Game::getHome_pts).setHeader("Home Pts");
        grid.addColumn(game -> game.getLocation_id().getLocation_name() + game.getLocation_id().getLocation_address()).setHeader("Location");
        grid.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);




        if(grid.equals(middleSchoolGames)){
            grid.setItems(gamesService.getMiddleSchoolGames());
        } else if (grid.equals(jrGames)) {
            grid.setItems(gamesService.getJrGames());
        }else {
            grid.setItems(gamesService.getSrGames());
        }
    }

}
