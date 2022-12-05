package com.example.courseproject.controller;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Profile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableViewProfileController {

    @FXML
    private TableView<Profile> tableViewProfile;
    @FXML
    private TableColumn<Profile, String> profile_idColumn;
    @FXML
    private TableColumn<Profile, String> nazvanie_profilaColumn;

    ObservableList<Profile> observableList = FXCollections.observableArrayList();

    Database database = new Database();

    @FXML
    void initialize() {
        showData();

        profile_idColumn.setCellValueFactory(new PropertyValueFactory<>("profile_id"));
        nazvanie_profilaColumn.setCellValueFactory(new PropertyValueFactory<>("nazvanie_profila"));
        tableViewProfile.setItems(observableList);
    }

    private void showData() {
        try {
            Connection connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM profile");
            while (resultSet.next()) {
                observableList.add(new Profile(resultSet.getInt("profile_id"), resultSet.getString("nazvanie_profila")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
