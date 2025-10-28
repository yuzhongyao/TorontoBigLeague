package com.example.demo.views.components;

import com.example.demo.entities.Team;
import com.example.demo.entities.TeamStanding;
import com.example.demo.services.*;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.TabSheetVariant;
import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamStandingsGrid extends VerticalLayout {

    private final transient AuthenticationContext authenticationContext;
    private final TeamsService teamsService;
    private final AgesService agesService;
    private final GamesService gamesService;
    private final SeasonsService seasonsService;
    private final SessionsService sessionsService;

    private final LocationsService locationsService;
    Grid<TeamStanding> grade8 = new Grid<>();
    Grid<TeamStanding> jrRepGrid = new Grid<>();
    Grid<TeamStanding> srRepGrid = new Grid<>();
    Grid<TeamStanding> jrPrepGrid = new Grid<>();
    Grid<TeamStanding> srPrepGrid = new Grid<>();


    @Autowired
    public TeamStandingsGrid(AuthenticationContext authenticationContext, TeamsService teamsService, AgesService agesService, GamesService gamesService, SeasonsService seasonsService, SessionsService sessionsService, LocationsService locationsService){
        this.authenticationContext = authenticationContext;
        this.teamsService = teamsService;
        this.agesService = agesService;
        this.gamesService = gamesService;
        this.seasonsService = seasonsService;
        this.sessionsService = sessionsService;
        this.locationsService = locationsService;

        this.setAlignSelf(Alignment.CENTER);
        this.setAlignItems(Alignment.CENTER);

        TabSheet tabSheet = new TabSheet();

        Tab rep = new Tab("Rep");

        Accordion repAccordian = new Accordion();
        //        ('Grade 8'),  --1
//        ('Grade 9'),  --2
//        ('Grade 10'), --3
//        ('Grade 11'), --4
//        ('Grade 12'), --5
//        ('Jr Prep'),       --6
//        ('Sr Prep'),       --7
//        ('Jr Rep'),        --8
//        ('Sr Rep');        --9
//        Sr                 --10
//        Jr              --11
        List<TeamStanding> grade8Standings = teamsService.findTeamStandings(1);
        grade8.setItems(grade8Standings);
        List<TeamStanding> jrRepStandings = teamsService.findTeamStandings(8);
        jrRepGrid.setItems(jrRepStandings);
        List<TeamStanding> srRepStandings = teamsService.findTeamStandings(9);
        srRepGrid.setItems(srRepStandings);
        List<TeamStanding> jrPrepStandings = teamsService.findTeamStandings(6);
        jrPrepGrid.setItems(jrPrepStandings);
        List<TeamStanding> srPrepStandings = teamsService.findTeamStandings(7);
        srPrepGrid.setItems(srPrepStandings);

//        ConfigureGrid(grade8);
        ConfigureGrid(jrRepGrid);
        ConfigureGrid(srRepGrid);
        ConfigureGrid(jrPrepGrid);
        ConfigureGrid(srPrepGrid);

//        repAccordian.add("Grade 8", grade8);
        repAccordian.add("JR Rep", jrRepGrid);
        repAccordian.add("SR Rep", srRepGrid);

        Tab prep = new Tab("Prep");

        Accordion prepAccordian = new Accordion();
        prepAccordian.add("JR Prep", jrPrepGrid);
        prepAccordian.add("SR Prep",srPrepGrid);

        tabSheet.add(prep, prepAccordian);
        tabSheet.add(rep,repAccordian);
        tabSheet.addThemeVariants(TabSheetVariant.LUMO_TABS_CENTERED);
        tabSheet.setWidthFull();
        add(tabSheet);
    }

    public void ConfigureGrid(Grid<TeamStanding> grid){
        grid.addColumn(TeamStanding::getTeamName).setHeader("Team").setAutoWidth(true).setFlexGrow(1);
        grid.addColumn(TeamStanding::getGamesPlayed).setHeader("GP").setAutoWidth(true).setFlexGrow(1);
        grid.addColumn(TeamStanding::getWins).setHeader("W").setAutoWidth(true).setFlexGrow(1);
        grid.addColumn(TeamStanding::getLosses).setHeader("L").setAutoWidth(true).setFlexGrow(1);
        grid.addColumn(TeamStanding::getPointsFor).setHeader("PF").setAutoWidth(true).setFlexGrow(1);
        grid.addColumn(TeamStanding::getPointsAgainst).setHeader("PA").setAutoWidth(true).setFlexGrow(1);
        grid.addColumn(TeamStanding::getWinPercentage).setHeader("WPCT").setAutoWidth(true).setFlexGrow(1);
        grid.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        grid.addThemeVariants(GridVariant.LUMO_COMPACT);

        if(authenticationContext.isAuthenticated()){
            grid.addItemClickListener(item ->{
                TeamStanding teamStanding = item.getItem();

                Team team = teamsService.findTeamById(teamStanding.getId()).get();

                Dialog editor = new Dialog();
                editor.setHeaderTitle("Edit Team Details");

            });
        }


    }




}
