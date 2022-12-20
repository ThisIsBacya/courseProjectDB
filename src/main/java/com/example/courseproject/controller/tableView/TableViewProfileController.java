package com.example.courseproject.controller.tableView;

import com.example.courseproject.HelloApplication;
import com.example.courseproject.database.Database;
import com.example.courseproject.model.Profile;
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

public class TableViewProfileController {

    @FXML
    private TableView<Profile> tableViewProfile;
    @FXML
    private TableColumn<Profile, String> profile_idColumn;
    @FXML
    private TableColumn<Profile, String> nazvanie_profilaColumn;

    @FXML
    private JFXButton addProfile;

    @FXML
    private JFXButton deleteProfile;

    @FXML
    private JFXButton update;

    ObservableList<Profile> observableList = FXCollections.observableArrayList();

    Database database = new Database();
    Connection connection = null;

    @FXML
    void initialize() {
        showData();
        profile_idColumn.setCellValueFactory(new PropertyValueFactory<>("profile_id"));
        nazvanie_profilaColumn.setCellValueFactory(new PropertyValueFactory<>("nazvanie_profila"));
        tableViewProfile.setItems(observableList);

        addProfile.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addProfile.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Добавить профиль");
            stage.showAndWait();
        });
        update.setOnAction(actionEvent -> {
            observableList.clear();
            try {
                ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM profile ORDER BY profile_id ASC");
                while (resultSet.next()) {
                    observableList.add(new Profile(resultSet.getInt("profile_id"), resultSet.getString("nazvanie_profila")));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        deleteProfile.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("deleteProfile.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Удалить профиль");
            stage.showAndWait();
        });
    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM profile ORDER BY profile_id ASC");
            while (resultSet.next()) {
                observableList.add(new Profile(resultSet.getInt("profile_id"), resultSet.getString("nazvanie_profila")));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}