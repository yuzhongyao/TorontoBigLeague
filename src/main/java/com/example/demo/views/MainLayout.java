package com.example.demo.views;

import com.example.demo.views.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout(){
        createHeader();
    }

    private void createHeader() {

        //Logo image
        Image logoImage = new Image();
        logoImage.setSrc("https://dpaacptq7x5t0.cloudfront.net/bigleaguelogoWhite.png");
        logoImage.setWidth("125px");
        logoImage.addClassName("logo-image");

        /*Desktop version */
        //logo
        H1 logo = new H1("");

        //link components
        RouterLink home = new RouterLink("", MainView.class);
        RouterLink aboutUs = new RouterLink("About Us", AboutUsView.class);
        RouterLink schedule = new RouterLink("Schedule", ScheduleView.class);
        RouterLink standings = new RouterLink("Standings", Standings.class);
        RouterLink contactUs = new RouterLink("Contact Us", ContactUsView.class);
//        RouterLink registration = new RouterLink("Register", RegistrationView.class);

        //home.addClassName("navbar-link");
        home.add(logoImage);
        aboutUs.addClassName("navbar-link");
        schedule.addClassName("navbar-link");
        standings.addClassName("navbar-link");
        contactUs.addClassName("navbar-link");
//        registration.addClassName("navbar-link");

        logo.add(home);

        HorizontalLayout menu = new HorizontalLayout(
                aboutUs,
                schedule,
                standings,
                contactUs
//                registration
        );
//        menu.setAlignSelf(FlexComponent.Alignment.END);
//        menu.getStyle().set("margin-left", "auto");
//        menu.getStyle().set("gap", "0px");
//        menu.getStyle().setColor("#fa5856");
        style(menu);

        HorizontalLayout Desktop = new HorizontalLayout(
                logo, menu
        );

        Desktop.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.END);
        Desktop.setWidth("100%");
        Desktop.setMinHeight("100px");
        Desktop.addClassName("desktop");

        /*laptop */
        //logo
        H1 logo3 = new H1("");
        //Logo image
        Image logoImage3 = new Image();
        logoImage3.setSrc("https://dpaacptq7x5t0.cloudfront.net/bigleaguelogoWhite.png");
        logoImage3.setWidth("125px");



        RouterLink home3 = new RouterLink("", MainView.class);
        home3.add(logoImage3);

        logo3.add(home3);

        RouterLink aboutUs3 = new RouterLink("About Us", AboutUsView.class);
        RouterLink schedule3 = new RouterLink("Schedule", ScheduleView.class);
        RouterLink standing3 = new RouterLink("Schedule", ScheduleView.class);
        RouterLink contactUs3 = new RouterLink("Contact Us", ContactUsView.class);
//        RouterLink registration3 = new RouterLink("Register", RegistrationView.class);

        HorizontalLayout menu3 = new HorizontalLayout(
                aboutUs3,
                schedule3,
                standing3,
                contactUs3
//                registration3
        );

        //home3.addClassName("navbar-link");
        aboutUs3.addClassName("navbar-link");
        schedule3.addClassName("navbar-link");
        standing3.addClassName("navbar-link");
        contactUs3.addClassName("navbar-link");
//        registration3.addClassName("navbar-link");
//        menu3.setAlignSelf(FlexComponent.Alignment.END);
//        menu3.getStyle().set("margin-left", "auto");
//        menu3.getStyle().set("gap", "0px");
//        menu3.getStyle().setColor("#fa5856");
        style(menu3);

        HorizontalLayout Laptop = new HorizontalLayout(
                logo3, menu3
        );
        Laptop.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.END);
        Laptop.setWidth("100%");
        Laptop.setMinHeight("100px");
        Laptop.addClassName("laptop");


        /*Mobile Version*/
        //logo
        H1 logo2 = new H1("");
        //Logo image
        Image logoImage2 = new Image();
        logoImage2.setSrc("https://dpaacptq7x5t0.cloudfront.net/bigleaguelogoWhite.png");
        logoImage2.setWidth("125px");


        RouterLink home2 = new RouterLink("", MainView.class);
        home2.add(logoImage2);

        logo2.add(home2);
        //home2.addClassName("navbar-link");

        ContextMenu contextMenu = new ContextMenu();


        contextMenu.setOpenOnClick(true);

        Icon menuIcon = new Icon(VaadinIcon.MENU);
        menuIcon.setColor("white");
        menuIcon.setSize("40px");

        Button menuButton = new Button(menuIcon);
        menuButton.addClickListener(event -> {
            // Handle menu dropdown
            contextMenu.removeAll();
// Add menu items
            contextMenu.addItem("About Us", e -> {
                // Handle item 1 click
                getUI().get().navigate("/aboutus");
                contextMenu.close();
            });
            contextMenu.addItem("Schedule", e -> {
                // Handle item 2 click
                getUI().get().navigate("/schedule");
                contextMenu.close();

            });
            contextMenu.addItem("Standings", e -> {
                // Handle item 2 click
                getUI().get().navigate("/standings");
                contextMenu.close();
            });
            contextMenu.addItem("Contact Us", e -> {
                // Handle item 3 click
                getUI().get().navigate("/contactus");
                contextMenu.close();
            });
//            contextMenu.addItem("Register", e -> {
//                // Handle item 3 click
//                getUI().get().navigate("/registration");
//                contextMenu.close();
//            });

        });
        contextMenu.setTarget(menuButton);

        HorizontalLayout menu2 = new HorizontalLayout();
        menu2.add(menuButton);
//        menu2.setAlignSelf(FlexComponent.Alignment.END);
//        menu2.getStyle().set("margin-left", "auto");
//        menu2.getStyle().set("gap", "0px");
//        menu2.getStyle().setColor("#fa5856");
        style(menu2);


        HorizontalLayout Mobile = new HorizontalLayout(
                logo2, menu2
        );



        Mobile.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.END);
        Mobile.setWidth("100%");
        Mobile.setMinHeight("100px");
        Mobile.addClassName("mobile");


        addToNavbar(Desktop);
        addToNavbar(Laptop);
        addToNavbar(Mobile);




    }

    private void style(HorizontalLayout h){
        h.setAlignSelf(FlexComponent.Alignment.END);
        h.getStyle().set("margin-left", "auto");
        h.getStyle().set("gap", "0px");
        h.getStyle().setColor("#fa5856");

    }

}
