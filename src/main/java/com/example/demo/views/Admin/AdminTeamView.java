package com.example.demo.views.Admin;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "/admin/team", layout = AdminLayout.class)
@RolesAllowed("ADMIN")
public class AdminTeamView extends VerticalLayout {
}
