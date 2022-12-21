package com.example.courseproject.controller.addAndDelete;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Poseshaemost;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.Date;

public class DeleteOtchetController {

    @FXML
    private Button clearButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField idOtchetField;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        database.getConnection();
        deleteButton.setOnAction(actionEvent -> {
            int idOtchet = Integer.parseInt(idOtchetField.getText());
            Poseshaemost poseshaemost = new Poseshaemost(idOtchet);
            database.removeOtchet(poseshaemost);
            System.out.println("Отчет удален");
        });
        clearButton.setOnAction(actionEvent -> {
            idOtchetField.setText(null);
        });
    }
}
