// Доделать

package com.example.courseproject.controller;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Gruppa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    ObservableList<Gruppa> observableList = FXCollections.observableArrayList();

    Database database = new Database();

    @FXML
    void initialize() {
        showData();

        gruppaIdColumn.setCellValueFactory(new PropertyValueFactory<>("gruppa_id"));
        gruppaNomerColumn.setCellValueFactory(new PropertyValueFactory<>("gruppa_nomer"));
        godPostupleniaColumn.setCellValueFactory(new PropertyValueFactory<>("god_postuplenia"));
        profileIdColumn.setCellValueFactory(new PropertyValueFactory<>("profile_id"));
        formaObucheniaColumn.setCellValueFactory(new PropertyValueFactory<>("forma_obuchenia"));
        tableViewGruppa.setItems(observableList);
    }

    private void showData() {
        try {
            Connection connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM gruppa");
            while (resultSet.next()) {
                observableList.add(new Gruppa(resultSet.getInt("gruppa_id"), resultSet.getString("gruppa_nomer"),
                        resultSet.getInt("god_postuplenia"), resultSet.getInt("profile_id"), resultSet.getString("forma_obuchenia")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
    }
}