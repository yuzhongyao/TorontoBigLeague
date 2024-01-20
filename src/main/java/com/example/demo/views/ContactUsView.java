package com.example.demo.views;

import com.example.demo.views.components.Footer;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Contact Us | Toronto Big League")
@Route(value = "/contactus", layout = MainLayout.class)
public class ContactUsView extends VerticalLayout {

    public ContactUsView(){
        this.setPadding(false);
        H1 title = new H1();
        title.setText("Contact Us");
        title.getElement().getStyle().set("padding-top", "146.82px");

        Div titleDiv = new Div();
        title.addClassName("center");
        titleDiv.add(title);
        titleDiv.addClassName("center");
        titleDiv.setWidthFull();


        Div formContainer = new Div();
        formContainer.addClassName("form-div");

        Div paragraphContainer = new Div();
        paragraphContainer.addClassName("p");
        H2 subtitle = new H2();

        subtitle.setText("\"Have a Question?\n" +
                "Contact Us Today!\"");
        Paragraph bodyParagraph = new Paragraph();
        bodyParagraph.setText("Need to get in touch with us? We'd love to hear from you!" +
                " Use the form provided to send us a message, and one of our team members will get back to you as soon as possible." +
                " You may also follow one of our social media links below and contact us through there." +
                " We look forward to connecting with you!");

        paragraphContainer.add(subtitle);
        paragraphContainer.add(bodyParagraph);
        formContainer.add(paragraphContainer);
        formContainer.add(new ContactUsLayout());
        add(titleDiv);
        add(formContainer);
        add(new Footer());

    }

}
