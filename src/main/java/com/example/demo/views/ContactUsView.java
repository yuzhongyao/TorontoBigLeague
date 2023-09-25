package com.example.demo.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Contact Us")
@Route(value = "/contactus", layout = MainLayout.class)
public class ContactUsView extends VerticalLayout {

    public  ContactUsView(){

    }
}

