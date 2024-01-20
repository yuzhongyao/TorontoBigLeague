package com.example.demo.views;

import com.example.demo.data.HighSchoolSchedule;
import com.example.demo.data.MiddleSchoolSchedule;
import com.example.demo.data.Schedule;
import com.example.demo.views.components.Footer;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
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
        sessionTitle.setText("January 27-28 Session Schedule");
        sessionTitle.addClassName("center");

        H2 satTitle = new H2();
        satTitle.setWidthFull();
        satTitle.setText("Saturday January 27");
        satTitle.addClassName("center");

        Text satLocation = new Text("");
        satLocation.setText("AT Sir Wilfrid Laurier C.I., 145 Guildwood Pkwy, Scarborough, ON M1E 1P5");

        Grid<Schedule> sat = new Grid<>(Schedule.class,false);
        sat.getElement().getStyle().set("margin-left", "10px");
        sat.getElement().getStyle().set("margin-right", "10px");
        sat.addColumn(Schedule::getTime).setHeader("Time").setAutoWidth(true);;
        sat.addColumn(Schedule::getAge).setHeader("Age").setAutoWidth(true);;
        sat.addColumn(Schedule::getHome).setHeader("Home").setAutoWidth(true);;
        sat.addColumn(Schedule::getAway).setHeader("Away").setAutoWidth(true);;

        List<Schedule> satList = Arrays.asList(
                new Schedule("12PM", "Sr", "M&R", "IEM"),
                new Schedule( "1PM", "Jr", "V3 Prep", "Oakville Prep"),
                new Schedule("2:30PM", "Sr", "Shield", "M&R"),
                new Schedule("3:30PM", "Sr", "V3 Regional", "Team Trappings"),
                new Schedule("5PM", "Sr", "Shield", "IEM")

                );

        sat.setItems(satList);


        H2 sunTitle = new H2();
        sunTitle.setWidthFull();
        sunTitle.setText("Sunday January 28");
        sunTitle.addClassName("center");

        Text sunLocation = new Text("");
        sunLocation.setText("AT O'Neill Collegiate and Vocational Institute, 301 Simcoe St N, Oshawa, ON L1G 4T2");

        Grid<Schedule> sun = new Grid<>(Schedule.class,false);
        sun.getElement().getStyle().set("margin-left", "10px");
        sun.getElement().getStyle().set("margin-right", "10px");

        List<Schedule> sunList = Arrays.asList(
                new Schedule("10AM", "Sr", "Code Regional", "Team Trappings"),
                new Schedule( "11:30AM", "Sr", "Code GTA", "V3 Regional"),
                new Schedule( "1PM", "Jr", "V3 Prep", "Project Excellence B"),
                new Schedule( "2:30PM", "Sr", "Code Regional", "V3 Regional"),
                new Schedule( "4PM", "Sr", "Shield", "Code GTA"),
                new Schedule("5PM", "Jr", "BM Elite", "Oakville Prep"),
                new Schedule( "6:30PM", "Sr", "Shield", "4 Ever Ballers"),
                new Schedule("7:30PM", "Jr", "Oakville Prep", "Project Excellence B"),
                new Schedule( "9PM", "Sr", "Team Trappings", "BM Elite")

        );
        sun.addColumn(Schedule::getTime).setHeader("Time").setAutoWidth(true);;
        sun.addColumn(Schedule::getAge).setHeader("Age").setAutoWidth(true);;
        sun.addColumn(Schedule::getHome).setHeader("Home").setAutoWidth(true);;
        sun.addColumn(Schedule::getAway).setHeader("Away").setAutoWidth(true);;

        sun.setItems(sunList);


        //saturday
        add(sessionTitle);
        Text disclaimer = new Text("*Schedule may change. Please double check.");

        Html br = new Html("<br>");
        Html br1 = new Html("<br>");
        add(satTitle, disclaimer,br,br1, satLocation,sat,sunTitle,sunLocation,sun);



        add(new Footer());


    }




}
