package com.example.demo.views.components;

import com.example.demo.entities.Game;
import com.example.demo.entities.Location;
import com.example.demo.entities.Team;
import com.example.demo.services.*;
import com.example.demo.util.UTILS;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.TabSheetVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.spring.security.AuthenticationContext;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ScheduleGrid extends VerticalLayout {

    private final transient AuthenticationContext authenticationContext;
    private final TeamsService teamsService;
    private final AgesService agesService;
    private final GamesService gamesService;
    private final SeasonsService seasonsService;
    private final LocationsService locationsService;

//    Grid<Game> pastMiddleSchoolGames = new Grid<>(Game.class, false);
//    Grid<Game> upcomingMiddleSchoolGames = new Grid<>(Game.class, false);

    Grid<Game> pastJrGames = new Grid<>(Game.class, false);
    Grid<Game> upcomingJrGames = new Grid<>(Game.class, false);
    Grid<Game> upcomingSrGames = new Grid<>(Game.class, false);


    Grid<Game> pastSrGames = new Grid<>(Game.class, false);
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

//        configureGrid(pastMiddleSchoolGames);
        configureGrid(pastJrGames);
        configureGrid(pastSrGames);

//        configureGrid(upcomingMiddleSchoolGames);
        configureGrid(upcomingJrGames);
        configureGrid(upcomingSrGames);

//        Tab grade8 = new Tab("Grade 8");


        Tab jr = new Tab("Grade 9/10 | Jr Prep");


        Tab sr = new Tab("Grade 11/12 | Sr Prep");

//        Accordion middleSchoolAccordian = new Accordion();
//        middleSchoolAccordian.add("Upcoming Games", upcomingMiddleSchoolGames);
//        middleSchoolAccordian.add("Past Games", pastMiddleSchoolGames );

        Accordion jrAccordion = new Accordion();
        jrAccordion.add("Upcoming Games", upcomingJrGames);
        jrAccordion.add("Past Games", pastJrGames );

        Accordion srAccordion = new Accordion();
        srAccordion.add("Upcoming Games", upcomingSrGames);
        srAccordion.add("Past Games", pastSrGames );


//        tabSheet.add(grade8, middleSchoolAccordian);
        tabSheet.add(jr,jrAccordion);
        tabSheet.add(sr,srAccordion);

        tabSheet.addThemeVariants(TabSheetVariant.LUMO_TABS_CENTERED);
        tabSheet.setWidthFull();
        add(tabSheet);

    }


    private void configureGrid(Grid<Game> grid){
        grid.addColumn(game -> game.getGame_date()).setHeader("Date").setWidth("50px").setFlexGrow(0);

        grid.addColumn(game -> game.getGame_time().format(DateTimeFormatter.ofPattern("HH:mm"))).setHeader("Time").setAutoWidth(true).setFlexGrow(0);
//        grid.addColumn(game -> game.getHome_id().getTeam_name()).setHeader("H");
        grid.addColumn(
                        LitRenderer.<Game>of(
                                        "<span style='${item.home_pts > item.away_pts ? \"font-weight: bold;\" : \"\"}'>${item.home_name}</span>"
                                )
                                .withProperty("home_pts", Game::getHome_pts)
                                .withProperty("away_pts", Game::getAway_pts)
                                .withProperty("home_name", game -> game.getHome_id().getTeam_name())
                )
                .setHeader("H");
//        grid.addColumn(Game::getHome_pts).setHeader("H Pts").setAutoWidth(true).setFlexGrow(0).setPartNameGenerator(game -> {
//            if(game.getHome_pts() > game.getAway_pts()){
//                return "font-weight-bold";
//            }
//            else {
//                return "";
//            }
//        });
        grid.addColumn(
                        LitRenderer.<Game>of(
                                        "<span style='${item.home_pts > item.away_pts ? \"font-weight: bold;\" : \"\"}'>${item.home_pts}</span>"
                                )
                                .withProperty("home_pts", Game::getHome_pts)
                                .withProperty("away_pts", Game::getAway_pts)
                )
                .setHeader("H Pts")
                .setAutoWidth(true)
                .setFlexGrow(0);
//        grid.addColumn(game -> game.getAway_id().getTeam_name()).setHeader("A");
        grid.addColumn(
                        LitRenderer.<Game>of(
                                        "<span style='${item.away_pts > item.home_pts ? \"font-weight: bold;\" : \"\"}'>${item.away_name}</span>"
                                )
                                .withProperty("home_pts", Game::getHome_pts)
                                .withProperty("away_pts", Game::getAway_pts)
                                .withProperty("away_name", game -> game.getAway_id().getTeam_name())
                )
                .setHeader("A");
        grid.addColumn(
                        LitRenderer.<Game>of(
                                        "<span style='${item.away_pts > item.home_pts ? \"font-weight: bold;\" : \"\"}'>${item.away_pts}</span>"
                                )
                                .withProperty("home_pts", Game::getHome_pts)
                                .withProperty("away_pts", Game::getAway_pts)
                )
                .setHeader("A Pts")
                .setAutoWidth(true)
                .setFlexGrow(0);
        grid.addColumn(game -> game.getLocation_id().getLocation_name() + " " + game.getLocation_id().getLocation_address()).setHeader("Location");
        grid.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);

        if(authenticationContext.isAuthenticated()){
            grid.addItemClickListener(item -> {
                Game game = item.getItem();

                Dialog editor = new Dialog();
                editor.setHeaderTitle("Edit Game Details");

                VerticalLayout editorLayout = new VerticalLayout();
                DatePicker datePicker = new DatePicker("Game Date");
                datePicker.setValue(game.getGame_date());
                TimePicker timePicker = new TimePicker("Game Time");
                timePicker.setStep(Duration.ofMinutes(5));
                timePicker.setValue(game.getGame_time());
                ComboBox<Team> away = new ComboBox<>("Away Team");

                List<Team> teams =teamsService.findAllByAgeGroup(game.getAge_id());
                away.setItems(teams);
                away.setItemLabelGenerator(Team::getTeam_name);
                away.setValue(game.getAway_id());

//                TextField awayPoints = new TextField("Away Points");
                TextField awayPoints = new TextField("Away Points");
                awayPoints.setValue(String.valueOf(game.getAway_pts()));

                ComboBox<Team> home = new ComboBox<>("Home Team");
                home.setItemLabelGenerator(Team::getTeam_name);
                home.setItems(teams);
                home.setValue(game.getHome_id());
//                TextField homePoints = new TextField("Home Points");
                TextField homePoints = new TextField("Home Points");
                homePoints.setValue(String.valueOf(game.getHome_pts()));

                ComboBox<Location> locationComboBox = new ComboBox<>("Locations");
                locationComboBox.setItems(locationsService.findAll());
                locationComboBox.setValue(game.getLocation_id());
                locationComboBox.setItemLabelGenerator(Location::getLocation_name);

                Button delete = new Button("Delete");
                delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
                delete.addClickListener(click -> {
                    gamesService.deleteById(game.getGame_id());
                    UTILS.showNotification(new Notification(),"SUCCESSFULLY DELETED", true);
                    grid.getDataProvider().refreshAll();
                    editor.close();
                });

                Button close = new Button("Cancel", (e) -> editor.close());
                close.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

                Button save = new Button("Save");
                save.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
                save.addClickListener(click -> {
                    game.setGame_date(datePicker.getValue());
                    game.setGame_time(timePicker.getValue());
                    game.setAway_id(away.getValue());
                    game.setHome_id(home.getValue());
                    game.setAway_pts(Short.parseShort(awayPoints.getValue()));
                    game.setHome_pts(Short.parseShort(homePoints.getValue()));
                    game.setLocation_id(locationComboBox.getValue());
                    gamesService.updateGame(game);
                    grid.getDataProvider().refreshItem(game);
                    editor.close();
                    UTILS.showNotification(new Notification(),"SUCCESSFULLY SAVED", true);

                });

                editorLayout.add(datePicker,timePicker,away,awayPoints,home,homePoints,locationComboBox);
                editor.add(editorLayout);
                editor.getFooter().add(delete,close,save);
                editor.open();

            });
        }


        if (grid.equals(pastJrGames)) {
            grid.setItems(gamesService.getPastJrGames());
        }
        else if (grid.equals(upcomingJrGames)) {
            grid.setItems(gamesService.getJrGames());
        }else if(grid.equals(upcomingSrGames)) {
            grid.setItems(gamesService.getSrGames());
        }
        else {
            grid.setItems(gamesService.getPastSrGames());
        }
    }

}
