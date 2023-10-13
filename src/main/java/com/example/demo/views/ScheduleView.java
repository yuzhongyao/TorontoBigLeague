package com.example.demo.views;

import com.example.demo.data.HighSchoolSchedule;
import com.example.demo.data.MiddleSchoolSchedule;
import com.example.demo.views.components.Footer;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
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

        add(title);
        add(middleTitle);
        add(scheduleGrid);
        add(highTitle);
        add(highSchoolScheduleGrid);
        add(subTitle);
        add(link);
        add(new Footer());


    }




}
