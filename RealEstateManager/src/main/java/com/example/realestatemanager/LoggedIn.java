package com.example.realestatemanager;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class LoggedIn {
    public static Scene createScene() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        Label helloLabel = new Label("Hello");
        layout.getChildren().add(helloLabel);

        return new Scene(layout, 300, 275);
    }
}