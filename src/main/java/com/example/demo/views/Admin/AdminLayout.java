package com.example.demo.views.Admin;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.security.AuthenticationContext;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class AdminLayout extends AppLayout {

    private final transient AuthenticationContext authenticationContext;
    public AdminLayout(AuthenticationContext authenticationContext, AuthenticationContext authenticationContext1){
        this.authenticationContext = authenticationContext1;
        createHeader();
        createDrawer();
        this.setDrawerOpened(false);
    }

    public void createHeader(){
        HorizontalLayout header = new HorizontalLayout();
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();

        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("TBL");
        title.getStyle().setColor("WHITE");
        RouterLink home = new RouterLink("", AdminView.class);
        home.add(title);

        header.add(toggle, home);
        addToNavbar(header);

    }

    public void createDrawer(){

        VerticalLayout list = new VerticalLayout();

        RouterLink home = new RouterLink("Home", AdminView.class);
        home.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink schedule = new RouterLink("Schedule", AdminScheduleView.class);
        RouterLink team = new RouterLink("Teams", AdminTeamView.class);


        Button logout = new Button();
        logout.setText("Logout");
        logout.addClickListener(buttonClickEvent -> {
            authenticationContext.logout();;
        });

        list.add(home, schedule, team, logout);
        addToDrawer(list);


    }

}
