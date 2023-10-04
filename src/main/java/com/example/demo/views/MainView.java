package com.example.demo.views;

import com.example.demo.views.components.Footer;
import com.example.demo.views.components.Video;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Toronto Big League")
@Route(value = "/home", layout = MainLayout.class)
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

        Video backgroundVideo = new Video("https://dpaacptq7x5t0.cloudfront.net/TBLTrim.mp4");
        videoContainer.add(backgroundVideo);
        backgroundVideo.addClassName("background-video");

        //background image
        Div imageContainer = new Div();
        imageContainer.setWidthFull();
        imageContainer.addClassName("image-container");

        Image backgroundImage = new Image();
        backgroundImage.setSrc("images/poster.jpg");
        backgroundImage.addClassName("background-image");
        imageContainer.add(backgroundImage);

        // Main content
        Div main = new Div();
        main.addClassName("content");
        main.setWidthFull();

        //Middle school content
        Div middleDiv = new Div();
        H2 middleTitle = new H2();
        middleTitle.addClassName("center");
        middleTitle.setText("MIDDLE SCHOOL MADNESS");
        middleTitle.addClassName("white");
        middleTitle.addClassName("poster-title");
        middleDiv.add(middleTitle);
        //middle school poster div
        Div middlePosterDiv = new Div();
        middlePosterDiv.addClassName("poster-container");
        //Middle school poster
        Image middlePoster = new Image();
        middlePoster.setSrc("images/middle.png");
        middlePoster.addClassName("poster");


        //middle school list of league features
        UnorderedList middleList = new UnorderedList();
        ListItem item1 = new ListItem("Each team has 14 Games Guaranteed");
        ListItem item2 = new ListItem("$2,600 per team with a multi-team discount of $2,300 per team if you are able to bring 3 or more teams!");
        ListItem item3 = new ListItem("Games are live streamed on BallerTV");
        ListItem item4 = new ListItem("Games are uploaded to YouTube");
        ListItem item5 = new ListItem("Individual player stat keeping using BallerTV software");
        ListItem item6 = new ListItem("All Stars and MVPs will receive an Adidas prizepack");
        ListItem item7 = new ListItem("WINNING TEAM FROM EACH GRADE EARNS FREE ENTRY INTO ANY ADIDAS JR3SSB CIRCUIT SESSION!");
        middleList.add(item1);
        middleList.add(item2);
        middleList.add(item3);
        middleList.add(item4);
        middleList.add(item5);
        middleList.add(item6);
        middleList.add(item7);

        middlePosterDiv.add(middlePoster);
        middlePosterDiv.add(middleList);
        middleDiv.add(middlePosterDiv);

        //high school content
        Div highDiv = new Div();
        H2 highTitle = new H2();
        highTitle.addClassName("center");
        highTitle.setText("HIGH SCHOOL MADNESS");
        highTitle.addClassName("white");
        highTitle.addClassName("poster-title");
        highDiv.add(highTitle);
        //high school poster div
        Div highPosterDiv = new Div();
        highPosterDiv.addClassName("poster-container2");
        //high school poster
        Image highPoster = new Image();
        highPoster.setSrc("images/highschool.jpg");
        highPoster.addClassName("poster");


        //high school list of league features
        UnorderedList highList = new UnorderedList();
        ListItem item8 = new ListItem("Each team has 14 Games Guaranteed");
        ListItem item9 = new ListItem("$2,600 per team with a multi-team discount of $2,300 per team if you are able to bring 3 or more teams!");
        ListItem item10 = new ListItem("Games are live streamed on BallerTV");
        ListItem item11 = new ListItem("Games are uploaded to YouTube");
        ListItem item12 = new ListItem("Individual player stat keeping using BallerTV software");
        ListItem item13 = new ListItem("All Stars and MVPs will receive an Adidas prizepack");
        //ListItem item14 = new ListItem("WINNING TEAM FROM EACH GRADE EARNS FREE ENTRY INTO ANY ADIDAS JR3SSB CIRCUIT SESSION!");
        highList.add(item8);
        highList.add(item9);
        highList.add(item10);
        highList.add(item11);
        highList.add(item12);
        highList.add(item13);
        //highList.add(item14);

        highPosterDiv.add(highPoster);
        highPosterDiv.add(highList);
        highDiv.add(highPosterDiv);



        main.add(middleDiv);
        main.add(highDiv);
        main.add(new Footer());
        add(videoContainer);
        add(imageContainer);
        add(main);


        this.setPadding(false);
        this.addClassName("e");
    }
}
