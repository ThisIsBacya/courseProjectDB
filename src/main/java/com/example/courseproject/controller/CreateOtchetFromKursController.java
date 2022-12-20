package com.example.courseproject.controller;

import com.example.courseproject.database.Const;
import com.example.courseproject.database.Database;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class CreateOtchetFromKursController {

    @FXML
    private JFXButton createOtchetForMonthButton;

    @FXML
    private JFXButton createOtchetForSemestrButton;

    @FXML
    private JFXComboBox<String> comboBoxKurs;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        String[] items = {"1", "2", "3", "4"};
        comboBoxKurs.getItems().addAll(Arrays.toString(items));
        createOtchetForMonthButton.setOnAction(actionEvent -> {


        });

        createOtchetForSemestrButton.setOnAction(actionEvent -> {

        });
    }

}
