package com.example.courseproject.controller.createOtchet;

import com.example.courseproject.HelloApplication;
import com.example.courseproject.database.Database;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CreateOtchetFromGruppaController {

    @FXML
    private JFXButton createOtchetForMonthButton;

    @FXML
    private JFXButton createOtchetForSemestrButton;

    @FXML
    private TextField gruppaIdField;


    @FXML
    private JFXComboBox<String> gruppaComboBox;

    Database database = new Database();
    Connection connection = null;
    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        connection = database.getConnection();
        List<String> list = database.getGruppaNomer();
        for (String s: list) {
            gruppaComboBox.getItems().addAll(s);
        }
        Label label = new Label();
        gruppaComboBox.setOnAction(event -> label.setText(gruppaComboBox.getValue()));
        createOtchetForMonthButton.setOnAction(actionEvent -> {

        });

        createOtchetForSemestrButton.setOnAction(actionEvent -> {
            if (label.getText().equals("0091")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Gruppa/Semestr/semOtchetForGruppa0091.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Отчет");
                stage.showAndWait();
            }
            else if (label.getText().equals("0091зо")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Gruppa/Semestr/semOtchetForGruppa0091zo.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Отчет");
                stage.showAndWait();
            }
            else if (label.getText().equals("1091")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Gruppa/Semestr/semOtchetForGruppa1091.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Отчет");
                stage.showAndWait();
            }
            else if (label.getText().equals("1092")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Gruppa/Semestr/semOtchetForGruppa1092.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Отчет");
                stage.showAndWait();
            }
            else if (label.getText().equals("1095")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Gruppa/Semestr/semOtchetForGruppa1095.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Отчет");
                stage.showAndWait();
            }
            else if (label.getText().equals("9091")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Gruppa/Semestr/semOtchetForGruppa9091.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Отчет");
                stage.showAndWait();
            }
        });
    }

}
