package com.example.demo.views.components;


import com.example.demo.miscellaneous.MyIconsSvg;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import java.time.Year;
import java.util.Date;

@Route("/test")
public class Footer extends Div {

    public Footer(){
        this.setWidthFull();

        HorizontalLayout contentContainer = new HorizontalLayout();
        contentContainer.setPadding(false);
        contentContainer.addClassName("center");

        Div logoContainer = new Div();
        logoContainer.addClassName("center");

        Image logoImage = new Image();
        logoImage.setSrc("https://dpaacptq7x5t0.cloudfront.net/bigleaguelogoblack.png");
        logoImage.setWidth("150px");

        //social media
        Div socialContainer = new Div();
        socialContainer.addClassName("center");
        socialContainer.addClassName("social-container");
        //facebook
        Icon facebook = new Icon(VaadinIcon.FACEBOOK);
        facebook.setSize("40px");
        facebook.setColor("white");
        Anchor facebookLink = new Anchor("https://www.facebook.com/torontobigleague");
        facebookLink.add(facebook);
        //youtube
        Icon youtube = new Icon(VaadinIcon.YOUTUBE);
        youtube.setSize("40px");
        youtube.setColor("white");
        Anchor youtubeLink = new Anchor("https://www.youtube.com/@torontobigleague");
        youtubeLink.add(youtube);
        //Instagram
//        Icon instagram = new Icon(VaadinIcon.CAMERA);
//        instagram.setSize("40px");
//        instagram.setColor("white");
//        Anchor instagramLink = new Anchor("https://www.instagram.com/torontobigleague");
//        instagramLink.add(instagram);
        Image instagram = new Image();
        instagram.setSrc("https://dpaacptq7x5t0.cloudfront.net/instagram.png");
        instagram.setWidth("45px");
        Anchor instagramLink = new Anchor("https://www.instagram.com/torontobigleague");
        instagramLink.add(instagram);
        //Tiktok
        Icon tiktok = MyIconsSvg.TIKTOK.create();
        tiktok.setSize("40px");
        tiktok.setColor("white");
        Anchor tiktokLink = new Anchor("https://www.tiktok.com/@torontobigleague");
        tiktokLink.add(tiktok);
        //Mail
//        Icon mail = new Icon(VaadinIcon.ENVELOPE_O);
//        mail.setSize("40px");
//        mail.setColor("white");
//        Anchor mailLink = new Anchor("mailto:torontobigleague@gmail.com");
//        mailLink.add(mail);
        Image mail = new Image();
        mail.setSrc("https://dpaacptq7x5t0.cloudfront.net/mail.png");
        mail.setWidth("45px");
        Anchor mailLink = new Anchor("mailto:torontobigleague@gmail.com");
        mailLink.add(mail);
        socialContainer.add(facebookLink,youtubeLink, instagramLink,tiktokLink,mailLink);

        //copyright
        Html copyright = new Html("<p><b>&copy; " + Year.now() + " TORONTO BIG LEAGUE</p></b>");

        logoContainer.add(logoImage);
        contentContainer.add(logoContainer);
        contentContainer.add(socialContainer);
        contentContainer.add(copyright);
        add(contentContainer);

        this.addClassName("footer-container");
    }


}
