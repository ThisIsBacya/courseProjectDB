package com.example.courseproject.controller;

import javafx.event.Event;
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

        if(adminRadio.isSelected()) {
            nextButton.setOnAction(event -> {
                RadioButton selection = (RadioButton) group.getSelectedToggle();
                nextButton.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("resources/com.example.courseproject/registration.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Stage stage = new Stage();
                Parent parent = loader.getRoot();
                stage.setScene(new Scene(parent));
                stage.showAndWait();
            });
        }
    }

}
