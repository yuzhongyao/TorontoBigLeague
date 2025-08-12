package com.example.demo.views;

import com.example.demo.views.components.Footer;
import com.example.demo.views.components.Video;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Home | Toronto Big League")
@Route(value = "/home", layout = MainLayout.class)
@AnonymousAllowed
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
        backgroundImage.setSrc("https://dpaacptq7x5t0.cloudfront.net/poster.jpg");
        backgroundImage.addClassName("background-image");
        imageContainer.add(backgroundImage);

        // Main content
        Div main = new Div();
        main.addClassName("content");
        main.setWidthFull();



        //high school content
        Div highDiv = new Div();
        H2 highTitle = new H2();
        highTitle.addClassName("center");
        highTitle.setText("TBL PREP");
        highTitle.addClassName("white");
        highTitle.addClassName("poster-title");
        highDiv.add(highTitle);
        //high school poster div
        Div highPosterDiv = new Div();
        highPosterDiv.addClassName("center");

//        highPosterDiv.addClassName("poster-container2");
        //high school poster
        Image prep1 = new Image();
        prep1.setSrc("https://dpaacptq7x5t0.cloudfront.net/prep1.png");
        prep1.addClassName("poster");

        Image prep2 = new Image();
        prep2.setSrc("https://dpaacptq7x5t0.cloudfront.net/prep2.png");
        prep2.addClassName("poster");


        //high school list of league features
        UnorderedList highList = new UnorderedList();
        ListItem item8 = new ListItem("$780 per session");
        ListItem item9 = new ListItem("4 games per session");
        ListItem item10 = new ListItem("Teams MUST commit to at least 2 sessions to qualify for Championship");
        //ListItem item11 = new ListItem("GUARANTEED PRICE FREEZE for fully registered teams that return every year");
        ListItem item12 = new ListItem("Early registrants before September 30 are able to receive Adidas Team Pack* (contact for info)");
        ListItem item13 = new ListItem("Full games recorded and uploaded to YouTube");
        ListItem item14 = new ListItem("Team highlight videos on social media");



        //ListItem item14 = new ListItem("WINNING TEAM FROM EACH GRADE EARNS FREE ENTRY INTO ANY ADIDAS JR3SSB CIRCUIT SESSION!");
        highList.add(item8);
        highList.add(item9);
        highList.add(item10);
        //highList.add(item11);
        highList.add(item12);
        highList.add(item13);
        highList.add(item14);

        highPosterDiv.add(prep1);
        highPosterDiv.add(prep2);
        highPosterDiv.add(highList);
        highDiv.add(highPosterDiv);



//        main.add(middleDiv);
        main.add(highDiv);
        main.add(new Footer());
        add(videoContainer);
        add(imageContainer);
        add(main);


        this.setPadding(false);
        this.addClassName("e");
    }
}
