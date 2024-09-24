package com.example.demo.security;


import com.example.demo.views.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry.requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN");
            authorizationManagerRequestMatcherRegistry.requestMatchers(new AntPathRequestMatcher("/admin")).hasRole("ADMIN");
        });
        http.formLogin(httpSecurityFormLoginConfigurer -> {
            httpSecurityFormLoginConfigurer.successForwardUrl("/admin");
        });
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

    @Bean
    public UserDetailsService users(){
        UserDetails admin = User.builder()
                .username("tbl")
                .password(System.getenv("USER_PASSWORD"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }
}
