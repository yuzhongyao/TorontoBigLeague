package com.example.demo.miscellaneous;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.icon.IconFactory;
import java.util.Locale;

@JsModule("./icons/my-icons-svg.js")
public enum MyIconsSvg implements IconFactory {
    INSTAGRAM, MAIL, TIKTOK;

    public Icon create() {
        return new Icon(this.name().toLowerCase(Locale.ENGLISH).replace('_', '-').replaceAll("^-", ""));
    }

    public static final class Icon extends com.vaadin.flow.component.icon.Icon {
        Icon(String icon) {
            super("my-icons-svg", icon);
        }
    }
}