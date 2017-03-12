package com.example;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by ggladko97 on 12.03.17.
 */
public class MiniUI extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout con = new VerticalLayout(new Label("I'm mini"));
        con.setWidth(500,Unit.PIXELS);
        con.setHeight(500,Unit.PIXELS);
        setContent(con);

    }
}
