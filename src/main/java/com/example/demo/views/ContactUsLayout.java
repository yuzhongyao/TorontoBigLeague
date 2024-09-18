package com.example.demo.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.validator.EmailValidator;
import jakarta.mail.*;
import jakarta.mail.Authenticator;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import static org.junit.Assert.assertTrue;

public class ContactUsLayout extends FormLayout {

    private static final Logger logger = LoggerFactory.getLogger(ContactUsLayout.class);
    public ContactUsLayout(){
        createForm();
    }

    private void createForm() {

        Div formDiv = new Div();
        formDiv.addClassName("form-container");


        TextField nameField = new TextField("Name");
        nameField.setRequired(true);
        nameField.addClassName("f");

        EmailField emailField = new EmailField("Email");
        emailField.setRequired(true);
        emailField.addClassName("f");

        TextField phoneField = new TextField("Phone Number");
        phoneField.setRequired(true);
        phoneField.addClassName("f");

        TextField subjectField = new TextField("Subject");
        subjectField.addClassName("f");

        TextArea messageField = new TextArea("Message");
        messageField.setMinHeight("200px");
        messageField.addClassName("f");
        messageField.setRequired(true);

        Button send = new Button("Send");
        send.addClassName("f");
        send.addClickListener(event -> {
            String name = nameField.getValue();
            String email = emailField.getValue();
            String number = phoneField.getValue();
            String message = messageField.getValue();
            String subject = subjectField.getValue();

            // Validate input
            if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
                Notification.show("Please fill in all fields.");
                return;
            }
            if(emailField.isInvalid()){
                Notification.show("Please enter valid email.");
                return;
            }

            // Send the email
            try {
                sendEmail(name, subject, email,number, message);
                Notification.show("Email sent successfully!");
                nameField.clear();
                emailField.clear();
                phoneField.clear();
                messageField.clear();
                subjectField.clear();
            } catch (Exception e) {
                logger.error("Error sending email: {}", e.getMessage(), e);
                Notification.show("An error occurred while sending the email. Please try again later.");
            }
        });

        this.setResponsiveSteps(
                new ResponsiveStep("0", 1)
        );



        formDiv.add(nameField);
        formDiv.add(emailField);
        formDiv.add(phoneField);
        formDiv.add(subjectField);
        formDiv.add(messageField);
        formDiv.add(send);
        this.setWidth("50%");
        add(formDiv);



    }

    private void sendEmail(String name, String subject, String email, String number, String message) throws ConfigurationException {

        String to = "torontobigleague@gmail.com"; // Your business email address
        String from = email; // Your application's email address
        String host = "smtp.gmail.com"; // Gmail SMTP server
        String ssl = "465";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", ssl); // Port for SMTP server (e.g., 587 for TLS)
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", ssl);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", ssl);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


        if(subject.isEmpty()){
            subject = "New Contact Form Submission";
        }

        // Load the properties file
//        Configurations configs = new Configurations();
//        FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configs.propertiesBuilder("application.properties");
//        Configuration config = builder.getConfiguration();

        //        // Retrieve the credentials from the properties file
//        String username = config.getString("gmail.username");
//        String password = config.getString("gmail.password");
        // Retrieve credentials from environment variables
        String username = System.getenv("GMAIL");
        String password = System.getenv("GMAIL_PASSWORD");

        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        Session session = Session.getInstance(properties, authenticator);
        session.setDebug(false); //turn true for debug

        try{
            // create a message with headers
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress address = new InternetAddress(to);
            msg.setRecipient(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());

            // create message body
            Multipart mp = new MimeMultipart();
            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setText("Sender Name: " + name+ " \n "
                    +"Sender Email: " +email+ " \n " + "Phone Number: " + number + " \n " + message, "us-ascii");
            mp.addBodyPart(mbp);

            msg.setContent(mp);

            // send the message
            Transport.send(msg);

        }catch (Exception e){
            e.printStackTrace();

        }

    }



}





