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
    private static final PropertyDescriptor<String, String> typeDescriptor = PropertyDescriptors.attributeWithDefault(
            "type",
            "video/mp4" // Set the default type as "video/mp4"
    );

    public Video() {
        super();
        getElement().setProperty("autoplay", true);
        getElement().setProperty("loop", true);
        getElement().setAttribute("muted", true);
        setType("video/mp4"); // Set the type attribute
    }

    public Video(String src) {
        setSrc(src);
        getElement().setProperty("autoplay", true);
        getElement().setProperty("loop", true);
        getElement().setAttribute("muted", true);
        setType("video/mp4"); // Set the type attribute
    }

    public String getSrc() {
        return get(srcDescriptor);
    }

    public void setSrc(String src) {
        set(srcDescriptor, src);
    }

    public String getType() {
        return get(typeDescriptor);
    }

    public void setType(String type) {
        set(typeDescriptor, type);
    }
}

