package com.example.demo.views;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Splash | Toronto Big League")
@Route("")
@AnonymousAllowed
public class SplashView extends Div  {

    public SplashView(){
        H1 welcome = new H1();
        welcome.setText("WELCOME TO THE BIG LEAGUE");
        welcome.addClassName("splash-title");

        RouterLink home = new RouterLink("ENTER", MainView.class);


        add(welcome,home);
        this.addClassName("splash-container");
    }


}
