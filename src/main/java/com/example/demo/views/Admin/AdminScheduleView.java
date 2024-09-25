package com.example.demo.views.Admin;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "/admin/schedule", layout = AdminLayout.class)
@RolesAllowed("ADMIN")
public class AdminScheduleView extends VerticalLayout {
}
