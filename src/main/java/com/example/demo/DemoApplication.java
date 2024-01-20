package com.example.demo;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Inline;
import com.vaadin.flow.component.page.TargetElement;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Theme("my-theme")
public class DemoApplication implements AppShellConfigurator {

	@Override
	public void configurePage(AppShellSettings settings){
		settings.addInlineFromFile(
				TargetElement.HEAD, Inline.Position.APPEND,
				"google.html", Inline.Wrapping.AUTOMATIC
		);
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
