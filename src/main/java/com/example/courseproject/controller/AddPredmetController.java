package com.example.courseproject.controller;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Predmet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddPredmetController {

    @FXML
    private Button addButton;

    @FXML
    private TextField chasiField;

    @FXML
    private Button clearButton;

    @FXML
    private TextField predmetField;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        database.getConnection();
        addButton.setOnAction(actionEvent -> {
            String nazvPredmeta = predmetField.getText();
            int chasi = Integer.parseInt(chasiField.getText());
            Predmet predmet = new Predmet(nazvPredmeta, chasi);
            database.addPredmet(predmet);
            System.out.println("Предмет добавлен");
        });
    }
}