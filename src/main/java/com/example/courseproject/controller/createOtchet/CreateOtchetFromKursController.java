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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

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
            if (label.getText().equals("1")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/Month/monthOtchetForFirstKurs.fxml"));
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
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/Month/monthOtchetForSecondKurs.fxml"));
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
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/Month/monthOtchetForThirdKurs.fxml"));
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
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/Month/monthOtchetForFourthKurs.fxml"));
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

        createOtchetForSemestrButton.setOnAction(actionEvent -> {
            if (label.getText().equals("1")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/Semestr/semOtchetForFirstKurs.fxml"));
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
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/Semestr/semOtchetForSecondKurs.fxml"));
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
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/Semestr/semOtchetForThirdKurs.fxml"));
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
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/Kurs/Semestr/semOtchetForFourthKurs.fxml"));
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