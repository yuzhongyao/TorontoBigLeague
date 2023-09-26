package com.example.demo.views;

import com.example.demo.data.Schedule;
import com.example.demo.views.components.Footer;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.*;

@PageTitle("Schedule")
@Route(value = "/schedule", layout = MainLayout.class)

public class ScheduleView extends VerticalLayout {

    public ScheduleView(){

        add(new MainLayout());
        this.setPadding(false);

        H1 title = new H1();
        title.setWidthFull();
        title.setText("Session Dates");
        title.addClassName("center");

        Grid<Schedule> scheduleGrid = new Grid<>(Schedule.class);
        scheduleGrid.getElement().getStyle().set("margin-left", "10px");
        scheduleGrid.getElement().getStyle().set("margin-right", "10px");
        List<Schedule> schedules = Arrays.asList(
                new Schedule("Grade 4", "Nov 25-26", "Dec 9-10", "Jan 13-14", "Feb 24-25", "Mar 9-10"),
                new Schedule("Grade 5", "Nov 25-26", "Dec 9-10", "Jan 13-14", "Feb 24-25", "Mar 9-10"),
                new Schedule("Grade 6", "Nov 25-26", "Dec 9-10", "Jan 13-14", "Feb 24-25", "Mar 9-10"),
                new Schedule("Grade 7", "Nov 11-12", "Dec 2-3", "Jan 20-21", "Feb 17-18", "Mar 2-3"),
                new Schedule("Grade 8", "Nov 11-12", "Dec 2-3", "Jan 20-21", "Feb 17-18", "Mar 2-3"),
                new Schedule("Grade 9", "TBD", "TBD", "TBD", "TBD", "TBD"),
                new Schedule("Grade 10", "TBD", "TBD", "TBD", "TBD", "TBD"),
                new Schedule("Grade 11", "TBD", "TBD", "TBD", "TBD", "TBD"),
                new Schedule("Grade 12", "TBD", "TBD", "TBD", "TBD", "TBD")



        );

        scheduleGrid.setItems(schedules);

        H2 subTitle = new H2();
        subTitle.setText("Game Schedules");
        Anchor link = new Anchor();
        link.setHref("https://basketball.exposureevents.com/209083/middle-school-madness");
        link.setText("Game schedule Link");

        add(title);
        add(scheduleGrid);
        add(subTitle);
        add(link);
        add(new Footer());


    }




}
