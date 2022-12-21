package com.example.courseproject.controller.tableView.admin;

import com.example.courseproject.HelloApplication;
import com.example.courseproject.database.Database;
import com.example.courseproject.model.Poseshaemost;
import com.example.courseproject.model.Profile;
import com.example.courseproject.model.User;
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

public class TableViewUsersController {

    @FXML
    private JFXButton addUser;

    @FXML
    private JFXButton deleteUser;

    @FXML
    private TableColumn<User, String> loginUserColumn;

    @FXML
    private TableColumn<User, String> passwordUserColumn;

    @FXML
    private TableColumn<User, String> roleUserColumn;

    @FXML
    private TableView<User> tableViewUsers;

    @FXML
    private JFXButton update;

    ObservableList<User> observableList = FXCollections.observableArrayList();

    Database database = new Database();
    Connection connection = null;

    @FXML
    void initialize() {
        showData();
        loginUserColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        passwordUserColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        roleUserColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        tableViewUsers.setItems(observableList);
        addUser.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Add and Delete/addUser.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Добавить пользователя");
            stage.showAndWait();
        });
        update.setOnAction(actionEvent -> {
            observableList.clear();
            try {
                ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users ORDER BY user_id ASC");
                while (resultSet.next()) {
                    observableList.add(new User(resultSet.getString("login"), resultSet.getString("password"),
                            resultSet.getString("role")));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        deleteUser.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Add and Delete/deleteUser.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Добавить пользователя");
            stage.showAndWait();
        });
    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users ORDER BY user_id ASC");
            while (resultSet.next()) {
                observableList.add(new User(resultSet.getString("login"), resultSet.getString("password"),
                        resultSet.getString("role")));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
