package com.example.realestatemanager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationScene {
    public static Scene createScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField confirmPasswordField = new PasswordField();

        grid.add(new Label("Username:"), 0, 1);
        grid.add(usernameField, 1, 1);

        grid.add(new Label("Password:"), 0, 2);
        grid.add(passwordField, 1, 2);

        grid.add(new Label("Confirm Password:"), 0, 3);
        grid.add(confirmPasswordField, 1, 3);

        Button registerButton = new Button("Register");
        grid.add(registerButton, 1, 6);

        registerButton.setOnAction(e -> {
            if (!passwordField.getText().equals(confirmPasswordField.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Passwords do not match!", ButtonType.OK);
                alert.showAndWait();
                return;
            }
            try (Connection conn = DatabaseConnection.getConnection()) {
                    String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setString(1, usernameField.getText());
                        pstmt.setString(2, passwordField.getText());
                        pstmt.executeUpdate();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Registration successful!", ButtonType.OK);
                        alert.showAndWait();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Registration failed: " + ex.getMessage(), ButtonType.OK);
                    alert.showAndWait();
                }
        });
        return new Scene(grid, 350, 400);
    }
}