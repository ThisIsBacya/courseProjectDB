package com.example.courseproject.controller;

import com.example.courseproject.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.w3c.dom.events.MouseEvent;

public class StudentController {

    @FXML
    private TextField inputTextId;

    @FXML
    private Button nextButtonId;

    Database database = null;

    @FXML
    void initialize() {
        database = new Database();
    }
}
