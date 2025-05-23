package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        TextField name = new TextField("Tên của bạn");
        Button helloBtn = new Button("Chào");

        helloBtn.addClickListener(e -> {
            add(new Paragraph("Xin chào, " + name.getValue()));
        });

        add(name, helloBtn);
    }
}
