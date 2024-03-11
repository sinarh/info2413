package com.example.realestatemanager;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label userName = new Label("Username:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        grid.add(btn, 1, 4);

        btn.setOnAction(e -> {
            if (LoginService.authenticate(userTextField.getText(), pwBox.getText())) {
                primaryStage.setScene(LoggedIn.createScene());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username or password.", ButtonType.OK);
                alert.showAndWait();
            }
        });

        Button registerButton = new Button("Register");
        grid.add(registerButton, 1, 5);
        registerButton.setOnAction(e -> {
            primaryStage.setScene(RegistrationScene.createScene(primaryStage));
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
