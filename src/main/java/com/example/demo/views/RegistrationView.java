package com.example.demo.views;


import com.example.demo.views.components.Footer;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

//@PageTitle("Registration | Toronto Big League")
//@Route(value = "/registration", layout = MainLayout.class)
//@AnonymousAllowed
public class RegistrationView extends VerticalLayout {

    public RegistrationView(){

        //embedded youtube video
        Div youtubeDiv = new Div();
        //youtube.addClassName("center");
        youtubeDiv.addClassName("youtube-container");

        IFrame video = new IFrame("https://www.youtube.com/embed/oyJRk8tIDSg?si=W3lhnaeOSGLrh-cl");
        video.setAllow("accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture; web-share; clipboard-write");
        video.getElement().setAttribute("allowfullscreen", true);
        video.getElement().setAttribute("frameborder", "0");
        video.setClassName("center");
//        video.setWidth("560px");
//        video.setHeight("315px");
        video.getElement().setAttribute("loading","lazy");
        video.setId("myFrame");

        //youtubeDiv.add(video);
        VerticalLayout videoLayout = new VerticalLayout();
        videoLayout.setAlignItems(Alignment.CENTER);
        videoLayout.add(video);

        this.setWidthFull();
        this.setPadding(false);

        H1 title = new H1();
        title.setText("Registration");
        title.setWidthFull();
        title.addClassName("center");
        title.getElement().getStyle().set("padding-top", "146.82px");





        add(title);
        add(videoLayout);

        add(new Footer());

    }
}
