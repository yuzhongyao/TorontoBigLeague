package com.example.demo.views.components;

import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Tag;


@Tag("source")
public class Source extends HtmlComponent {

    public Source() {
        // Constructor for the <source> tag
        super();
    }

    public Source(String src) {
        setSrc(src);
        setType("video/mp4");
    }

    public String getSrc() {
        return getElement().getAttribute("src");
    }

    public void setSrc(String src) {
        getElement().setAttribute("src", src);
    }

    public String getType() {
        return getElement().getAttribute("type");
    }

    public void setType(String type) {
        getElement().setAttribute("type", type);
    }
}
