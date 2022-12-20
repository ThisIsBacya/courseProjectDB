package com.example.courseproject.controller.addAndDelete;

import com.example.courseproject.database.Const;
import com.example.courseproject.database.Database;
import com.example.courseproject.model.Poseshaemost;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddOtchetController {

    @FXML
    private Button addButton;
    @FXML
    private Button clearButton;

    @FXML
    private TextField chasiField;


    @FXML
    private JFXComboBox<String> comboBoxType;

    @FXML
    private TextField typeField;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField predmetIdField;

    @FXML
    private TextField studentIdIdField;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException{
        database.getConnection();
        String[] items = {"уважительная", "неуважительная"};
        comboBoxType.getItems().addAll(items);
        addButton.setOnAction(actionEvent -> {
            Date date = Date.valueOf(dateField.getValue());
            int studentId = Integer.parseInt(studentIdIdField.getText());
            int predmetId = Integer.parseInt(predmetIdField.getText());
            int chasiPropuska = Integer.parseInt(chasiField.getText());
            String type = comboBoxType.getSelectionModel().getSelectedItem();
            Poseshaemost poseshaemost = new Poseshaemost(date, studentId, predmetId, chasiPropuska, type);
            database.addPoseshaemost(poseshaemost);
            System.out.println("Добавлен новый отчет!");
        });
        clearButton.setOnAction(actionEvent -> {
            studentIdIdField.setText(null);
            predmetIdField.setText(null);
            chasiField.setText(null);
            typeField.setText(null);
        });
    }
}