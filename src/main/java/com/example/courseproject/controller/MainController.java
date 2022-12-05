package com.example.courseproject.controller;

import com.example.courseproject.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private RadioButton adminRadio = new RadioButton();
    @FXML
    private RadioButton prepodRadio = new RadioButton();
    @FXML
    private RadioButton studentRadio = new RadioButton();
    @FXML
    private Button nextButton;

    @FXML
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        studentRadio.setToggleGroup(group);
        prepodRadio.setToggleGroup(group);
        adminRadio.setToggleGroup(group);
        RadioButton selection = (RadioButton) group.getSelectedToggle();
        nextButton.setOnAction(event -> {
            if (studentRadio.isSelected()) {
                nextButton.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("studentLogin.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Окно входа для студента");
                stage.showAndWait();
            }
            if(prepodRadio.isSelected()) {
                nextButton.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("userLogin.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException();
                }

                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Окно входа для преподавателя");
                stage.showAndWait();
            }

            if (adminRadio.isSelected()) {
                nextButton.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("adminLogin.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException();
                }

                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Окно входа для администратора");
                stage.showAndWait();
            }
        });
    }
}
