package com.example.courseproject.controller.createOtchet;

import com.example.courseproject.HelloApplication;
import com.example.courseproject.database.Const;
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
        comboBoxKurs.getItems().addAll(items);
        Label label = new Label();
        comboBoxKurs.setOnAction(event -> label.setText(comboBoxKurs.getValue()));
        createOtchetForMonthButton.setOnAction(actionEvent -> {


        });

        createOtchetForSemestrButton.setOnAction(actionEvent -> {
            if (label.getText().equals("1")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/semOtchetForFirstKurs.fxml"));
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
            else if (label.getText().equals("2")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/semOtchetForSecondKurs.fxml"));
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
            else if (label.getText().equals("3")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/semOtchetForThirdKurs.fxml"));
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
            else if (label.getText().equals("4")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/semOtchetForFourthKurs.fxml"));
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
