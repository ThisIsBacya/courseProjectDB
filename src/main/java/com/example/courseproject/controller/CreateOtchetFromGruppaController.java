package com.example.courseproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateOtchetFromGruppaController {

    @FXML
    private JFXButton createOtchetForMonthButton;

    @FXML
    private JFXButton createOtchetForSemestrButton;

    @FXML
    private TextField gruppaIdField;

    @FXML
    void initialize() {
        createOtchetForMonthButton.setOnAction(actionEvent -> {

        });

        createOtchetForSemestrButton.setOnAction(actionEvent -> {

        });
    }

}
