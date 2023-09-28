package com.example.demo.views.components;

import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.PropertyDescriptors;
import com.vaadin.flow.component.Tag;

@Tag("video")
public class Video extends HtmlContainer {
    private static final PropertyDescriptor<String, String> srcDescriptor = PropertyDescriptors.attributeWithDefault(
            "src",
            ""
    );

    public Video() {
        super();
        getElement().setAttribute("controls", false);
        getElement().setProperty("autoplay", true);
        getElement().setProperty("loop", true);
        getElement().setAttribute("muted", true);
        getElement().setAttribute("allowfullscreen",false);
    }

    public Video(String src) {
        setSrc(src);
        getElement().setAttribute("controls", false);
        getElement().setProperty("autoplay", true);
        getElement().setProperty("loop", true);
        getElement().setAttribute("muted", true);
        getElement().setAttribute("allowfullscreen",false);

    }

    public String getSrc() {
        return get(srcDescriptor);
    }

    public void setSrc(String src) {
        set(srcDescriptor, src);
    }

}
