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
        getElement().setAttribute("autoplay", true);
        getElement().setAttribute("muted", true);
        getElement().setAttribute("loop", true);
//        getElement().setAttribute("type", "video/mp4");
        getElement().setAttribute("controls", false);
        getElement().setAttribute("playsinline", true);
        getElement().setAttribute("preload", "auto");
        getElement().setAttribute("poster", "images/poster.jpg");
        add(new Source());
    }

    public Video(String src) {
//        setSrc(src);
        getElement().setAttribute("autoplay", true);
        getElement().setAttribute("muted", true);
        getElement().setAttribute("loop", true);
//        getElement().setAttribute("type", "video/mp4");
        getElement().setAttribute("controls", false);
        getElement().setAttribute("playsinline", true);
        getElement().setAttribute("poster", "images/poster.jpg");
        getElement().setAttribute("preload", "auto");
        add(new Source(src));

    }

    public String getSrc() {
        return get(srcDescriptor);
    }

    public void setSrc(String src) {
        set(srcDescriptor, src);
    }

}
