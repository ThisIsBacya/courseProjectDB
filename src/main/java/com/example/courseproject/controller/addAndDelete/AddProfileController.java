package com.example.courseproject.controller.addAndDelete;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Predmet;
import com.example.courseproject.model.Profile;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddProfileController {

    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField profileField;

    Database database = new Database();

    @FXML
    void initialize() {
        addButton.setOnAction(actionEvent -> {
            String nazvProfile = profileField.getText();
            Profile profile = new Profile(nazvProfile);
            database.addProfile(profile);
            System.out.println("Профиль добавлен!");
        });
        clearButton.setOnAction(actionEvent -> {
            profileField.setText(null);
        });
    }
}