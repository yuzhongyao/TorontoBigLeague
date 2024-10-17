package com.example.demo.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.security.AuthenticationContext;

@Route("login")
@AnonymousAllowed
public class LoginView extends VerticalLayout  {

    private final transient AuthenticationContext authenticationContext;

    public LoginView(AuthenticationContext authenticationContext){
        this.authenticationContext = authenticationContext;
        setSizeFull();
        setAlignItems(Alignment.CENTER);

        var login = new LoginForm();
        login.setAction("login");
        H1 title = new H1("Toronto Big League");

        this.add(title, login);
    }

//    @Override
//    public void beforeEnter(BeforeEnterEvent event) {
//        if(authenticationContext.isAuthenticated()){
//            authenticationContext.logout();
//        }
//    }

}
