package com.example.demo.security;


import com.example.demo.views.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        super.configure(http);
        setLoginView(http, LoginView.class);
    }
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder =DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url(System.getenv("DATASOURCE_URL"));
        dataSourceBuilder.username(System.getenv("DATASOURCE_USERNAME"));
        dataSourceBuilder.password(System.getenv("DATASOURCE_PASSWORD"));
        return dataSourceBuilder.build();
    }
}
