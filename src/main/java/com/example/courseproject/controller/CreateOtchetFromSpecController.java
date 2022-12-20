package com.example.courseproject.controller;

import com.example.courseproject.HelloApplication;
import com.example.courseproject.controller.otchet.SemOtchetForPovtController;
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
import java.sql.Connection;
import java.sql.SQLException;
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
        for (String s : list) {
            specComboBox.getItems().addAll(s);
        }
        Label label = new Label();
        specComboBox.setOnAction(event -> label.setText(specComboBox.getValue()));


        createOtchetForMonthButton.setOnAction(actionEvent -> {


        });

        createOtchetForSemestrButton.setOnAction(actionEvent -> {
            if (label.getText().equals("Программирование в компьютерных системах")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/semOtchetForPovt.fxml"));
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
            else if (label.getText().equals("Компьютерные системы и комплексы")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/semOtchetForKss.fxml"));
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
            else if (label.getText().equals("Мобильная разработка на Android")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/semOtchetForMobile.fxml"));
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
            else if (label.getText().equals("Разработка игр")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/semOtchetForGameDev.fxml"));
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
            else if (label.getText().equals("Web-программирование")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/semOtchetForWeb.fxml"));
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
            else if (label.getText().equals("Разработка баз данных")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/semOtchetForDatabase.fxml"));
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
            else if (label.getText().equals("Информационная безопасность")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/semOtchetForInfoBez.fxml"));
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
            else if (label.getText().equals("Big Data")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Otchet/semOtchetForBigData.fxml"));
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
