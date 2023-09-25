package com.example.demo.views;

import com.example.demo.views.components.Video;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Toronto Big League")
@Route(value = "", layout = MainLayout.class)
public class MainView extends VerticalLayout {

    public MainView(){
        add(new MainLayout());

        //title message
        H1 title = new H1();
        title.setWidthFull();
        title.addClassName("center");
        title.addClassName("title");
        title.setText("WELCOME TO THE BIG LEAGUE");
        this.setAlignItems(Alignment.CENTER);
        add(title);

        //background video
        Div videoContainer = new Div();
        videoContainer.setWidthFull();
        videoContainer.addClassName("video-container");

        Video backgroundVideo = new Video("videos/TBLTrim.mp4");
        videoContainer.add(backgroundVideo);
        backgroundVideo.addClassName("background-video");

    }
}
