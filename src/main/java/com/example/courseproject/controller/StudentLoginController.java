package com.example.courseproject.controller;

import com.example.courseproject.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StudentLoginController {

    @FXML
    private TextField inputTextId;

    @FXML
    private Button nextButtonId;

    Database database = null;

    @FXML
    void initialize() {
        database = new Database();
        nextButtonId.setOnAction(actionEvent -> {
            nextButtonId.getScene().getWindow().hide();

        });
    }
}
