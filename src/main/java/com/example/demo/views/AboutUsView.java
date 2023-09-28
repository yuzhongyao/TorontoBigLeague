package com.example.demo.views;

import com.example.demo.views.MainLayout;
import com.example.demo.views.components.Footer;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@PageTitle("About Us")
@Route(value = "/aboutus", layout = MainLayout.class)
public class AboutUsView extends VerticalLayout implements BeforeEnterObserver {

    public AboutUsView(){
        //header
        add(new MainLayout());
        this.setAlignItems(Alignment.CENTER);
        this.setPadding(false);

        //title
        H1 title = new H1();
        title.setText("Our Mission");

        //Mission paragraph
        Paragraph missionText = new Paragraph();
        missionText.setText("Cultivating excellence is at the core of Toronto Big League's mission. " +
                "We are deeply committed to advancing the landscape of basketball for athletes across Ontario, " +
                "and we do so with a steadfast dedication to quality and innovation.\n" +
                "\n" +
                "Our aim is to provide a higher level of basketball that not only challenges and nurtures the skills " +
                "of our athletes but also offers them a unique platform for recognition and exposure. In an increasingly " +
                "interconnected world, our vision extends beyond provincial borders, reaching across North America, where " +
                "we seek to showcase the talent and potential of our athletes to a broader audience.");

        //subtitle
        H2 h2 = new H2();
        h2.setText("How We Provide Exposure");

        //BallerTV
        H3 baller = new H3();
        baller.setText("BallerTV");
        //BallerTV paragraph
        Paragraph ballerText = new Paragraph();
        ballerText.setText("BallerTV stands as the foremost hub for amateur sports across North America, setting the standard in this domain. Thanks to their cutting-edge " +
                "technology and innovation, the platform simplifies the process for parents, friends, fans, coaches, and scouts to tune in and watch games. In our league, we rely " +
                "on BallerTV to seamlessly live stream all our matches. Moreover, BallerTV offers a range of features that enable athletes to effortlessly craft concise highlight videos, " +
                "significantly reducing the time required for this task.");

        //Social Media
        H3 social = new H3();
        social.setText("Social Media");
        //BallerTV paragraph
        Paragraph socialText = new Paragraph();
        socialText.setText("Our basketball league recognizes the immense potential of social media as a platform for showcasing the talents of our athletes. " +
                "By harnessing the power of various social media channels, we aim to provide unprecedented exposure for our players. Through captivating content, highlights, " +
                "and engaging posts, we ensure that the incredible skills and dedication of our athletes are celebrated and shared with a global audience. Social media not " +
                "only connects us with fans, supporters, and sponsors but also offers a unique opportunity for our players to build their personal brands and connect with fans " +
                "on a more intimate level.");

        //YouTube
        H3 youtube = new H3();
        youtube.setText("YouTube");
        //youtube paragraph
        Paragraph youtubeText = new Paragraph();
        youtubeText.setText("For those who missed our live stream on BallerTV and who want to see the full game, our league posts full game recordings on YouTube so " +
                "that you can watch the action anytime!");




        add(title);
        add(missionText);
        add(h2);
        add(youtube);
        add(youtubeText);
        add(baller);
        add(ballerText);
        add(social);
        add(socialText);
        add(new Footer());






    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        boolean isFirstVisit = !VaadinSession.getCurrent().getAttribute("visited").equals(Boolean.TRUE);

        if (isFirstVisit) {
            // Redirect to another page (e.g., "welcome" view)
            VaadinSession.getCurrent().setAttribute("visited", Boolean.TRUE );
            beforeEnterEvent.rerouteTo("/");
        }
    }
}
