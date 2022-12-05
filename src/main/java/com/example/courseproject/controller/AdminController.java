package com.example.courseproject.controller;

import com.example.courseproject.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private Button showTableViewStudents;

    @FXML
    private Button showTableViewProfile;

    @FXML
    private Button showTableViewGruppa;

    @FXML
    private Button showTableViewPredmet;

    @FXML
    void initialize() {
        showTableViewStudents.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tableViewStudents.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Таблица Студенты");
            stage.showAndWait();
        });

        showTableViewProfile.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tableViewProfile.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Таблица Студенты");
            stage.showAndWait();
        });
        showTableViewGruppa.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tableViewGruppa.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Таблицы Группа");
            stage.showAndWait();
        });
        showTableViewPredmet.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tableViewPredmet.fxml"));
            try {
                fxmlLoader.load();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Таблица Предметы");
            stage.showAndWait();
        });
    }
}
