package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.event.selection.SelectionListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.grid.GridConstants;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.components.grid.ItemClickListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by ggladko97 on 02.03.17.
 */
@SpringUI
@Theme("valo")
public class MyUI extends UI {
//
//    private final  VebinarvaadinApplication.MyService service;
//
//
//    @Autowired
//    public MyUI(VebinarvaadinApplication.MyService service){
//        this.service = service;
//    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        setContent(content);
        Notification toast = new Notification("Hi");
        toast.setPosition(Position.BOTTOM_CENTER);
        toast.setDelayMsec(2000);

        final String[] temp = {null};

        TextField textField = new TextField("Insert new prof for me");
        Button btnOk = new Button("Confirm");
        Button btnAddNewLayout = new Button("Add mini Layout");
        content.addComponents(textField,btnOk,btnAddNewLayout);
        btnOk.addClickListener((Button.ClickListener) clickEvent -> {
            temp[0] = textField.getValue();
            Notification.show(temp[0]);
        });
        btnAddNewLayout.addClickListener((Button.ClickListener) clickEvent -> content.addComponent(new MiniUI()));



        content.addComponent(new Label("<b>Hello</b>"));

        Grid <Person> grid = new Grid<>();

        grid.setCaption("My grid");
        Collection <Person> collection = new ArrayList<>();
        collection.add(new Person(1,"yevhenii",temp[0]));

//        Collection <String> collection = new ArrayList<>();
//        collection.add("Hladkevych");
        grid.addColumn(Person::getId).setCaption("id");
        grid.addColumn(Person::getName).setCaption("name");
        grid.addColumn(Person::getProf).setCaption("prof");
        grid.setItems(collection);
//        grid.addItemClickListener((ItemClickListener<Person>) itemClick -> Notification.show("I clicked "+ itemClick.getItem()));
//        grid.addSelectionListener(new SelectionListener<Person>() {
//            @Override
//            public void selectionChange(SelectionEvent<Person> event) {
//                Set<Person> selected = event.getAllSelectedItems();
//                Notification.show(selected.size() + " items selected");
//            }
//        });

        grid.setSizeFull();

        content.addComponent(grid);
        content.setExpandRatio(grid,1);


    }
}

