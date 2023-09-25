package com.example.demo.views;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("About Us")
@Route(value = "/aboutus", layout = MainLayout.class)
public class AboutUsView extends VerticalLayout {

    public AboutUsView(){

    }
}
