package com.example.demo.views;


import com.example.demo.views.components.Footer;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Registration")
@Route(value = "/registration", layout = MainLayout.class)
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

        H2 middle = new H2();
        middle.setText("Middle School Madness");
        middle.setWidthFull();
        Anchor middleLink = new Anchor();
        middleLink.setWidthFull();
        middleLink.addClassName("center");
        middleLink.setText("MIDDLE SCHOOL REGISTER");
        middleLink.setHref("https://forms.gle/4GSjpbGsamxErEhf6");

        H2 high = new H2();
        high.setText("High School Madness");
        high.setWidthFull();
        Anchor highLink = new Anchor();
        highLink.setWidthFull();
        highLink.addClassName("center");
        highLink.setText("HIGH SCHOOL REGISTER");
        highLink.setHref("https://forms.gle/WLLAfMPmqsAgc53P6");

        H2 men = new H2();
        men.setText("Mens' League");
        men.setWidthFull();
        Anchor menLink = new Anchor();
        menLink.setWidthFull();
        menLink.addClassName("center");
        menLink.setText("MENS REGISTER");
        menLink.setHref("https://forms.gle/mSZrygHzt5YPmWZh6");

        add(title);
        add(videoLayout);
        add(middle);
        add(middleLink);
        add(high);
        add(highLink);
        add(men);
        add(menLink);
        add(new Footer());

    }
}
