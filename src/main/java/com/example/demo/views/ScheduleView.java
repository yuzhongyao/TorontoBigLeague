package com.example.demo.views;

import com.example.demo.data.HighSchoolSchedule;
import com.example.demo.data.MiddleSchoolSchedule;
import com.example.demo.data.Schedule;
import com.example.demo.views.components.Footer;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
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
        sessionTitle.setText("Love & Basketball Tournament Schedule");
        sessionTitle.addClassName("center");

        Div div = new Div();
        div.setWidthFull();
        div.addClassName("center");

        H2 teamTitle = new H2();
        teamTitle.setText("Teams and Division");
        teamTitle.addClassName("center");

        H3 grade9Title = new H3("Grade 9");
        grade9Title.addClassName("center");

        UnorderedList grade9List = new UnorderedList();
        grade9List.getStyle().setColor("black");
        grade9List.add(new ListItem("Jump Basketball"),
                new ListItem("Metro Elite"),
                new ListItem("WC2P"),
                new ListItem("Motion"));

        H3 grade11Title = new H3("Grade 11");
        grade11Title.addClassName("center");

        UnorderedList grade11List = new UnorderedList();
        grade11List.getStyle().setColor("black");
        grade11List.add(new ListItem("Shield"),
                new ListItem("6BB"),
                new ListItem("Empower"),
                new ListItem("Foundation Basketball"));

        H3 grade12Title = new H3("Grade 12");
        grade12Title.addClassName("center");

        H4 grade12A = new H4("A");

        UnorderedList grade12List = new UnorderedList();
        grade12List.getStyle().setColor("black");
        grade12List.add(new ListItem("M&R"),
                new ListItem("Ballerz United"),
                new ListItem("Foundation Basketball")
                );

        H4 grade12B = new H4("B");

        UnorderedList grade12ListB = new UnorderedList();
        grade12ListB.getStyle().setColor("black");
        grade12ListB.add(new ListItem("WC2P"),
                new ListItem("TMU Elite"),
                new ListItem("True North")
        );

        div.add(teamTitle,grade9Title,grade9List,grade11Title,grade11List,grade12Title,grade12A,grade12List,grade12B,grade12ListB);

        H2 satTitle = new H2();
        satTitle.setWidthFull();
        satTitle.setText(" Saturday February 17");
        satTitle.addClassName("center");

        Text satLocation = new Text("");

        satLocation.setText("AT Bur Oak S.S., 933 Bur Oak Ave, Markham. Park and enter at the back of the school (Door ‘H’) by the portables");

        Grid<Schedule> sat = new Grid<>(Schedule.class,false);
        sat.getElement().getStyle().set("margin-left", "10px");
        sat.getElement().getStyle().set("margin-right", "10px");
        sat.addColumn(Schedule::getTime).setHeader("Time").setAutoWidth(true);;
        sat.addColumn(Schedule::getAge).setHeader("Grade").setAutoWidth(true);;
        sat.addColumn(Schedule::getHome).setHeader("Home").setAutoWidth(true);;
        sat.addColumn(Schedule::getAway).setHeader("Away").setAutoWidth(true);;

        List<Schedule> satList = Arrays.asList(
                new Schedule("8:15AM", "12", "M&R", "Foundation"),
                new Schedule( "9:15AM", "12", "WC2P", "True North"),
                new Schedule("10:15AM", "11", "Foundation", "Empower"),
                new Schedule("11:15AM", "12", "Foundation", "Ballerz United"),
                new Schedule("12:15PM", "11", "Shield", "Foundation"),
                new Schedule("1:15PM", "12", "TMU", "True North"),
                new Schedule("2:15PM", "12", "M&R", "Ballerz United")
                );

        sat.setItems(satList);

        Text satLocation2 = new Text("");

        satLocation2.setText("AT Bill Crothers S.S. 44 Main St Unionville. Park and enter at the back of the school");

        Grid<Schedule> sat2 = new Grid<>(Schedule.class,false);
        sat2.getElement().getStyle().set("margin-left", "10px");
        sat2.getElement().getStyle().set("margin-right", "10px");
        sat2.addColumn(Schedule::getTime).setHeader("Time").setAutoWidth(true);;
        sat2.addColumn(Schedule::getAge).setHeader("Grade").setAutoWidth(true);;
        sat2.addColumn(Schedule::getHome).setHeader("Home").setAutoWidth(true);;
        sat2.addColumn(Schedule::getAway).setHeader("Away").setAutoWidth(true);;

        List<Schedule> satList2 = Arrays.asList(
                new Schedule("6PM GYM A", "9", "Metro", "Jump"),
                new Schedule( "6PM GYM B", "11", "Empower", "Shield"),
                new Schedule("7PM GYM A", "9", "Motion", "WC2P"),
                new Schedule("7PM GYM B", "12", "TMU", "WC2P"),
                new Schedule("8PM GYM A", "11", "6BB", "Shield"),
                new Schedule("8PM GYM B", "9", "WC2P", "Jump"),
                new Schedule("9PM GYM A", "9", "Jump", "Motion"),
                new Schedule("9PM GYM B", "11", "6BB", "Empower")
                );
        sat2.setItems(satList2);

        H2 sunTitle = new H2();
        sunTitle.setWidthFull();
        sunTitle.setText("Sunday February 18");


        Text sunLocation = new Text("");
        sunLocation.setText("AT Miliken Mills H.S., 7522 Kennedy Rd, Markham");

        Grid<Schedule> sun = new Grid<>(Schedule.class,false);
        sun.getElement().getStyle().set("margin-left", "10px");
        sun.getElement().getStyle().set("margin-right", "10px");

        List<Schedule> sunList = Arrays.asList(
                new Schedule("8:30AM", "11", "6BB", "Foundation"),
                new Schedule( "9:30AM", "9", "WC2P", "Metro"),
                new Schedule( "10:30AM", "12", "A3", "B3"),
                new Schedule( "11:30AM Semi-finals", "12", "A1", "B2"),
                new Schedule( "12:30PM Semi-finals", "12", "B1", "A2"),
                new Schedule("1:30PM Finals", "11", "A1", "A2"),
                new Schedule( "2:30PM Finals", "12", "Semi winner", "Semi winner"),
                new Schedule("3:30PM Finals", "9", "A1", "A2")

        );
        sun.addColumn(Schedule::getTime).setHeader("Time").setAutoWidth(true);;
        sun.addColumn(Schedule::getAge).setHeader("Grade").setAutoWidth(true);;
        sun.addColumn(Schedule::getHome).setHeader("Home").setAutoWidth(true);;
        sun.addColumn(Schedule::getAway).setHeader("Away").setAutoWidth(true);;

        sun.setItems(sunList);


        //saturday
        add(sessionTitle);
        Text disclaimer = new Text("*Schedule may change. Please double check.");

        Html br = new Html("<br>");
        Html br1 = new Html("<br>");
        add(div,satTitle, disclaimer,br, br1, satLocation,sat,satLocation2, sat2,sunTitle,sunLocation,sun);



        add(new Footer());


    }




}
