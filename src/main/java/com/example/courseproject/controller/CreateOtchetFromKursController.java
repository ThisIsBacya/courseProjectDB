package com.example.courseproject.controller;

import com.example.courseproject.database.Const;
import com.example.courseproject.database.Database;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateOtchetFromKursController {

    @FXML
    private JFXButton createOtchetForMonthButton;

    @FXML
    private JFXButton createOtchetForSemestrButton;

    @FXML
    private TextField kursField;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        kursField.getText();
        createOtchetForMonthButton.setOnAction(actionEvent -> {

        });

        createOtchetForSemestrButton.setOnAction(actionEvent -> {

        });
    }

}
