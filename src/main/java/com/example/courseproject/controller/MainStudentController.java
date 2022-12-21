package com.example.courseproject.controller;

import com.example.courseproject.HelloApplication;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainStudentController {

    @FXML
    private JFXButton showTableViewPoseshaemost;

    @FXML
    private JFXButton showTableViewProfile;

    @FXML
    private JFXButton showTableViewStudents;


    @FXML
    void initialize() {
        showTableViewStudents.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TableViews/student/tableViewStudentsForStudent.fxml"));
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
        showTableViewPoseshaemost.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TableViews/student/tableViewPoseshaemostForStudent.fxml"));
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
    }

}
