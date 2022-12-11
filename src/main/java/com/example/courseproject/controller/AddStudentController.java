package com.example.courseproject.controller;

import com.example.courseproject.database.Const;
import com.example.courseproject.database.Database;
import com.example.courseproject.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddStudentController {

    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField fioField;

    @FXML
    private TextField gruppaIdField;

    @FXML
    private TextField nomerStudBiletField;

    @FXML
    private TextField specialnostField;

    Database database = new Database();
    String query = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Student student = null;
    private boolean update;
    int studentId;


    void initialize() throws SQLException, ClassNotFoundException {
        database.getConnection();
        addButton.setOnAction(actionEvent -> {
            String FIO = fioField.getText();
            String gruppaId = gruppaIdField.getId();
            String nomerStudBilet = nomerStudBiletField.getText();
            String specialnost = specialnostField.getText();

            if (FIO.isEmpty() || gruppaId.isEmpty() || nomerStudBilet.isEmpty() || specialnost.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Заполните, пожалуйста, все поля!");
                alert.showAndWait();
            }
            else {
                getQuery();
                insert();
                clear();

            }
        });

    }

    private void getQuery() {
        if (!update) {
            return;
        }
    }

    private void insert() {

    }

    @FXML
    private void clear() {
        fioField.setText(null);
        gruppaIdField.setText(null);
        nomerStudBiletField.setText(null);
        specialnostField.setText(null);
    }
}
