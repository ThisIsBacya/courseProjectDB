package com.example.courseproject.controller.tableView;

import com.example.courseproject.HelloApplication;
import com.example.courseproject.database.Database;
import com.example.courseproject.model.Gruppa;
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
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableViewGruppaController {

    @FXML
    private TableView<Gruppa> tableViewGruppa;

    @FXML
    private TableColumn<Gruppa, Integer> gruppaIdColumn;

    @FXML
    private TableColumn<Gruppa, String> gruppaNomerColumn;

    @FXML
    private TableColumn<Gruppa, Integer> godPostupleniaColumn;

    @FXML
    private TableColumn<Gruppa, Integer> profileIdColumn;

    @FXML
    private TableColumn<Gruppa, String> formaObucheniaColumn;

    @FXML
    private JFXButton addGruppa;

    @FXML
    private JFXButton deleteGruppa;


    @FXML
    private JFXButton update;

    ObservableList<Gruppa> observableList = FXCollections.observableArrayList();

    Database database = new Database();
    Connection connection = null;

    @FXML
    void initialize() {
        showData();

        gruppaIdColumn.setCellValueFactory(new PropertyValueFactory<>("gruppa_id"));
        gruppaNomerColumn.setCellValueFactory(new PropertyValueFactory<>("gruppa_nomer"));
        godPostupleniaColumn.setCellValueFactory(new PropertyValueFactory<>("god_postuplenia"));
        profileIdColumn.setCellValueFactory(new PropertyValueFactory<>("profile_id"));
        formaObucheniaColumn.setCellValueFactory(new PropertyValueFactory<>("forma_obuchenia"));
        tableViewGruppa.setItems(observableList);

        addGruppa.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Add and Delete/addGruppa.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Добавить группу");
            stage.showAndWait();
        });

        update.setOnAction(actionEvent -> {
            observableList.clear();
            try {
                ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM gruppa ORDER BY gruppa_id ASC");
                while (resultSet.next()) {
                    observableList.add(new Gruppa(resultSet.getInt("gruppa_id"), resultSet.getString("gruppa_nomer"),
                            resultSet.getInt("god_postuplenia"), resultSet.getInt("profile_id"), resultSet.getString("forma_obuchenia")));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        deleteGruppa.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Add and Delete/deleteGruppa.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Удалить группу");
            stage.showAndWait();
        });
    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM gruppa ORDER BY gruppa_id ASC");
            while (resultSet.next()) {
                observableList.add(new Gruppa(resultSet.getInt("gruppa_id"), resultSet.getString("gruppa_nomer"),
                        resultSet.getInt("god_postuplenia"), resultSet.getInt("profile_id"), resultSet.getString("forma_obuchenia")));
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}