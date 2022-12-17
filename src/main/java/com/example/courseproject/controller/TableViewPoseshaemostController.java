package com.example.courseproject.controller;

import com.example.courseproject.HelloApplication;
import com.example.courseproject.database.Database;
import com.example.courseproject.model.Poseshaemost;
import com.example.courseproject.model.Student;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableViewPoseshaemostController {

    @FXML
    private TableView<Poseshaemost> tableViewPoseshaemost;

    @FXML
    private TableColumn<Poseshaemost, Integer> poseshaemostIdColumn;

    @FXML
    private TableColumn<Poseshaemost, Date> datePropuskColumn;

    @FXML
    private TableColumn<Poseshaemost, Integer> predmetIdColumn;

    @FXML
    private TableColumn<Poseshaemost, Integer> studentsIdColumn;

    @FXML
    private TableColumn<Poseshaemost, Integer> chasiColumn;

    @FXML
    private TableColumn<Poseshaemost, String> typeColumn;


    @FXML
    private JFXButton update;

    @FXML
    private JFXButton addPoseshaemost;

    Database database = new Database();
    Connection connection = null;

    ObservableList<Poseshaemost> observableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        showData();

        poseshaemostIdColumn.setCellValueFactory(new PropertyValueFactory<>("poseshaemost_id"));
        datePropuskColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        studentsIdColumn.setCellValueFactory(new PropertyValueFactory<>("students_id"));
        predmetIdColumn.setCellValueFactory(new PropertyValueFactory<>("predmet_id"));
        chasiColumn.setCellValueFactory(new PropertyValueFactory<>("chasi_propuska"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableViewPoseshaemost.setItems(observableList);

        addPoseshaemost.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addOtchet.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Добавить отчет о посещаемости");
            stage.showAndWait();
        });

        update.setOnAction(actionEvent -> {
            observableList.clear();
            try {
                ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM poseshaemost ORDER BY poseshaemost_id ASC");
                while (resultSet.next()) {
                    observableList.add(new Poseshaemost(resultSet.getInt("poseshaemost_id"), resultSet.getDate("data"),
                            resultSet.getInt("students_id"), resultSet.getInt("predmet_id"), resultSet.getInt("chasi_propuska"), resultSet.getString("type")));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM poseshaemost ORDER BY poseshaemost_id ASC");
            while (resultSet.next()) {
                observableList.add(new Poseshaemost(resultSet.getInt("poseshaemost_id"), resultSet.getDate("data"),
                        resultSet.getInt("students_id"), resultSet.getInt("predmet_id"), resultSet.getInt("chasi_propuska"), resultSet.getString("type")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}