package com.example.demo.views;

import com.example.demo.data.HighSchoolSchedule;
import com.example.demo.data.MiddleSchoolSchedule;
import com.example.demo.data.Schedule;
import com.example.demo.views.components.Footer;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.*;

@PageTitle("Schedule | Toronto Big League")
@Route(value = "/schedule", layout = MainLayout.class)

public class ScheduleView extends VerticalLayout {

    public ScheduleView(){

        add(new MainLayout());
        this.setPadding(false);

        H1 title = new H1();
        title.setWidthFull();
        title.setText("Session Dates");
        title.addClassName("center");

        H2 middleTitle = new H2();
        middleTitle.setText("Middle School Madness");
        middleTitle.addClassName("center");

        Grid<MiddleSchoolSchedule> scheduleGrid = new Grid<>(MiddleSchoolSchedule.class);
        scheduleGrid.getElement().getStyle().set("margin-left", "10px");
        scheduleGrid.getElement().getStyle().set("margin-right", "10px");
        List<MiddleSchoolSchedule> middleSchoolSchedules = Arrays.asList(
                new MiddleSchoolSchedule("Grade 4", "Nov 25-26", "Dec 9-10", "Jan 13-14", "Feb 24-25", "Mar 9-10"),
                new MiddleSchoolSchedule("Grade 5", "Nov 25-26", "Dec 9-10", "Jan 13-14", "Feb 24-25", "Mar 9-10"),
                new MiddleSchoolSchedule("Grade 6", "Nov 25-26", "Dec 9-10", "Jan 13-14", "Feb 24-25", "Mar 9-10"),
                new MiddleSchoolSchedule("Grade 7", "Nov 11-12", "Dec 2-3", "Jan 20-21", "Feb 17-18", "Mar 2-3"),
                new MiddleSchoolSchedule("Grade 8", "Nov 11-12", "Dec 2-3", "Jan 20-21", "Feb 17-18", "Mar 2-3")
        );

        scheduleGrid.setItems(middleSchoolSchedules);

        Grid<HighSchoolSchedule> highSchoolScheduleGrid = new Grid<>(HighSchoolSchedule.class);
        highSchoolScheduleGrid.getElement().getStyle().set("margin-left", "10px");
        highSchoolScheduleGrid.getElement().getStyle().set("margin-right", "10px");
        List<HighSchoolSchedule> highSchoolSchedules = Arrays.asList(
                new HighSchoolSchedule("Grade 9", "Feb 24-25", "Mar 16-17", "Mar 23-24", "Apr 13-14", "Apr 27-28", "May 4-5", "May 18-19", "Jun 8-9"),
                new HighSchoolSchedule("Grade 10", "Feb 24-25", "Mar 16-17", "Mar 23-24", "Apr 13-14", "Apr 27-28", "May 4-5", "May 18-19", "Jun 8-9"),
                new HighSchoolSchedule("Grade 11", "Feb 24-25", "Mar 16-17", "Mar 23-24", "Apr 13-14", "Apr 27-28", "May 4-5", "May 18-19", "Jun 8-9"),
                new HighSchoolSchedule("Grade 12", "Feb 24-25", "Mar 16-17", "Mar 23-24", "Apr 13-14", "Apr 27-28", "May 4-5", "May 18-19", "Jun 8-9")
        );
        highSchoolScheduleGrid.setItems(highSchoolSchedules);

        H2 highTitle = new H2();
        highTitle.setText("High School Madness");
        highTitle.addClassName("center");

        H2 subTitle = new H2();
        subTitle.setText("Game Schedules");
        Anchor link = new Anchor();
        link.setHref("https://basketball.exposureevents.com/209083/middle-school-madness");
        link.setText("Game schedule Link");

//        add(title);
//        add(middleTitle);
//        add(scheduleGrid);
//        add(highTitle);
//        add(highSchoolScheduleGrid);
//        add(subTitle);
//        add(link);



        H1 sessionTitle = new H1();
        sessionTitle.setWidthFull();
        sessionTitle.setText("June 8-9 Summer Kickoff Tournament");
        sessionTitle.addClassName("center");

        Div div = new Div();
        div.setWidthFull();
        div.addClassName("center");

        VerticalLayout teams = new VerticalLayout();

        VerticalLayout g6 = new VerticalLayout();
        g6.setAlignSelf(Alignment.CENTER);
        H4 g6title = new H4("Grade 6");
        UnorderedList g6teams = new UnorderedList(new ListItem("Jaxx City"), new ListItem("Project Excellence"), new ListItem("IEM"), new ListItem("MBA"));
        g6teams.getStyle().setColor("Black");
        g6teams.setVisible(true);
        g6.add(g6title,g6teams);

        VerticalLayout g10 = new VerticalLayout();
        g10.setAlignSelf(Alignment.CENTER);
        H4 g10title = new H4("Grade 10");
        UnorderedList g10teams = new UnorderedList(new ListItem("DKH"), new ListItem("Project Excellence"), new ListItem("FBA Durham"), new ListItem("MBA"));
        g10teams.getStyle().setColor("Black");
        g10teams.setVisible(true);
        g10.add(g10title,g10teams);

        VerticalLayout g12 = new VerticalLayout();
        H5 pa = new H5("Pool A");
        g12.setAlignSelf(Alignment.CENTER);
        H4 g12title = new H4("Grade 12");
        UnorderedList g12teams = new UnorderedList(new ListItem("Project Excellence A"), new ListItem("PMG Elite"), new ListItem("WC2P"));
        g12teams.getStyle().setColor("Black");
        g12teams.setVisible(true);

        H5 pb = new H5("Pool B");
        UnorderedList g122teams = new UnorderedList(new ListItem("True North"), new ListItem("Project Excellence B"), new ListItem("DC United"), new ListItem("MBA"));
        g122teams.getStyle().setColor("Black");
        g122teams.setVisible(true);
        g12.add(g12title,pa, g12teams,pb, g122teams);

        teams.add(g6,g10,g12);




        H2 satTitle = new H2("Saturday June 8");
        satTitle.setWidthFull();

        Text satLocation = new Text("AT O'Neil CVI. 301 Simcoe St N, Oshawa, ON L1G 4T2");

        Grid<Schedule> sat = new Grid<>(Schedule.class, false);
        sat.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
//        sat.getElement().getStyle().set("margin-left", "10px");
//        sat.getElement().getStyle().set("margin-right", "10px");


        List<Schedule> satList = Arrays.asList(
                new Schedule("10AM", "Grade 6", "Jaxx City", "MBA"),
                new Schedule("11AM", "Grade 10", "MBA", "Project Excellence"),
                new Schedule( "12PM", "Grade 12", "Project Excellence B", "MBA"),
                new Schedule( "1PM", "Grade 6", "Project Excellence", "MBA"),
                new Schedule("2PM", "Grade 10", "MBA", "DKH"),
                new Schedule( "3PM", "Grade 12", "Project Excellence A", "PMG Elite"),
                new Schedule( "4PM", "Grade 12", "DC United", "MBA"),
                new Schedule( "5PM", "Grade 10", "Project Excellence", "DKH"),
                new Schedule( "6PM", "Grade 12", "DC United", "True North"),
                new Schedule( "7PM", "Grade 12", "PMG Elite", "WC2P"),
                new Schedule( "8PM", "Grade 12", "True North", "Project Excellence B"),
                new Schedule( "9PM", "Grade 12", "Project Excellence A", "WC2P")
                );

        sat.addColumn(Schedule::getTime).setHeader("Time").setAutoWidth(true);;
        sat.addColumn(Schedule::getAge).setHeader("Grade").setAutoWidth(true);;
        sat.addColumn(Schedule::getHome).setHeader("Home").setAutoWidth(true);;
        sat.addColumn(Schedule::getAway).setHeader("Away").setAutoWidth(true);;

        sat.setItems(satList);
        sat.setAllRowsVisible(true);

        Text satLocation2 = new Text("AT Alpha High Performance Centre, 455 Addison Hall Cir Unit 11-13, Aurora, ON L4G 3X8");
        Grid<Schedule> sat2 = new Grid<>(Schedule.class, false);
        sat2.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
//        sat2.getElement().getStyle().set("margin-left", "10px");
//        sat2.getElement().getStyle().set("margin-right", "10px");

        List<Schedule> satList2 = Arrays.asList(
                new Schedule("4PM", "Grade 6", "Jaxx City", "IEM"),
                new Schedule("6PM", "Grade 6", "Jaxx City", "Project Excellence"),
                new Schedule( "8PM", "Grade 6", "Project Excellence B", "IEM"),
                new Schedule( "9PM", "Grade 10", "Project Excellence", "FBA Durham")
        );

        sat2.addColumn(Schedule::getTime).setHeader("Time").setAutoWidth(true);;
        sat2.addColumn(Schedule::getAge).setHeader("Grade").setAutoWidth(true);;
        sat2.addColumn(Schedule::getHome).setHeader("Home").setAutoWidth(true);;
        sat2.addColumn(Schedule::getAway).setHeader("Away").setAutoWidth(true);;

        sat2.setItems(satList2);
        sat2.setAllRowsVisible(true);

        H2 sunTitle = new H2();
        sunTitle.setWidthFull();
        sunTitle.setText("Sunday June 9");


        Text sunLocation = new Text("");
        sunLocation.setText("Alpha High Performance Centre, 455 Addison Hall Cir Unit 11-13, Aurora, ON L4G 3X8");

        Grid<Schedule> sun = new Grid<>(Schedule.class,false);
        sun.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
//        sun.getElement().getStyle().set("margin-left", "10px");
//        sun.getElement().getStyle().set("margin-right", "10px");

        List<Schedule> sunList = Arrays.asList(

                new Schedule("10AM", "Grade 6", "IEM", "MBA")

                );


        sun.addColumn(Schedule::getTime).setHeader("Time").setAutoWidth(true);;
        sun.addColumn(Schedule::getAge).setHeader("Grade").setAutoWidth(true);;
        sun.addColumn(Schedule::getHome).setHeader("Home").setAutoWidth(true);;
        sun.addColumn(Schedule::getAway).setHeader("Away").setAutoWidth(true);;

        sun.setItems(sunList);
        sun.setAllRowsVisible(true);

        Text sunLocation2 = new Text("");
        sunLocation2.setText("AT O'Neil CVI. 301 Simcoe St N, Oshawa, ON L1G 4T2");

        Grid<Schedule> sun2 = new Grid<>(Schedule.class,false);
        sun2.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
//        sun2.getElement().getStyle().set("margin-left", "10px");
//        sun2.getElement().getStyle().set("margin-right", "10px");

        List<Schedule> sunList2 = Arrays.asList(

                new Schedule("10:30AM", "Grade 10", "FBA Durham", "MBA"),
                new Schedule("11:30AM G1", "Grade 12", "A1", "B2"),
                new Schedule("12:30PM", "Grade 10", "FBA Durham", "DKH"),
                new Schedule("1:30PM G2", "Grade 12", "B1", "A2"),
                new Schedule("2:30PM FINALS", "Grade 10", "1st", "2nd"),
                new Schedule("3:30PM", "Grade 12", "B3", "A3"),
                new Schedule("4:30PM", "Grade 12", "B4", "Dream Chaserz"),
                new Schedule("5:30PM FINALS", "Grade 6", "1st", "2nd"),
                new Schedule("6:30PM FINALS", "Grade 12", "G1W", "G2W")

                );


        sun2.addColumn(Schedule::getTime).setHeader("Time").setAutoWidth(true);;
        sun2.addColumn(Schedule::getAge).setHeader("Grade").setAutoWidth(true);;
        sun2.addColumn(Schedule::getHome).setHeader("Home").setAutoWidth(true);;
        sun2.addColumn(Schedule::getAway).setHeader("Away").setAutoWidth(true);;

        sun2.setItems(sunList2);
        sun2.setAllRowsVisible(true);

        //saturday
        add(sessionTitle);
        Text disclaimer = new Text("*Schedule may change. Please double check.");

        Html br = new Html("<br>");
        Html br1 = new Html("<br>");
        Html br2 = new Html("<br>");
        Html br3 = new Html("<br>");
        this.setAlignSelf(Alignment.CENTER);
        add(div, disclaimer, br, teams, satTitle, satLocation,sat, br1, satLocation2, sat2, br2,  sunTitle,sunLocation,sun,br3, sunLocation2, sun2);
//        add(div, disclaimer, br1, sunTitle,sunLocation,sun);




        add(new Footer());


    }




}
