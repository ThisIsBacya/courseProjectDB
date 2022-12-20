package com.example.courseproject.controller;

import com.example.courseproject.HelloApplication;
import com.example.courseproject.database.Database;
import com.example.courseproject.model.Profile;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateOtchetFromSpecController {

    @FXML
    private JFXButton createOtchetForMonthButton;

    @FXML
    private JFXButton createOtchetForSemestrButton;

    @FXML
    private JFXComboBox<String> specComboBox;

    Database database = new Database();
    Connection connection = null;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        connection = database.getConnection();
        List<String> list = database.getNazvProfile();
        for (int i = 0; i < list.size(); i++) {
            specComboBox.getItems().addAll(list.get(i));
        }

        createOtchetForMonthButton.setOnAction(actionEvent -> {

        });

        createOtchetForSemestrButton.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tableViewSpecSemestr.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Отчет за семестр по специальности");
            stage.showAndWait();
        });
    }
}
