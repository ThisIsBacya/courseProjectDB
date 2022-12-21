package com.example.courseproject.controller.tableView.prepod;

import com.example.courseproject.HelloApplication;
import com.example.courseproject.database.Database;
import com.example.courseproject.model.Predmet;
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

public class TableViewPredmetController {
    @FXML
    private TableView<Predmet> tableViewPredmet;
    @FXML
    private TableColumn<Predmet, Integer> predmet_idColumn;
    @FXML
    private TableColumn<Predmet, String> nazv_predmetaColumn;
    @FXML
    private TableColumn<Predmet, Integer> chasiColumn;

    ObservableList<Predmet> observableList = FXCollections.observableArrayList();

    Database database = new Database();
    Connection connection = null;

    @FXML
    void initialize() {
        showData();
        predmet_idColumn.setCellValueFactory(new PropertyValueFactory<>("predmet_id"));
        nazv_predmetaColumn.setCellValueFactory(new PropertyValueFactory<>("nazv_predmeta"));
        chasiColumn.setCellValueFactory(new PropertyValueFactory<>("chasi"));
        tableViewPredmet.setItems(observableList);
    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM predmet");
            while (resultSet.next()) {
                observableList.add(new Predmet(resultSet.getInt("predmet_id"), resultSet.getString("nazv_predmeta"), resultSet.getInt("chasi")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}