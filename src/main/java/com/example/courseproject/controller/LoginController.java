package com.example.courseproject.controller;

import com.example.courseproject.HelloApplication;
import com.example.courseproject.database.Database;
import com.example.courseproject.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField loginTextId;


    @FXML
    private PasswordField passwordTextId;

    @FXML
    private Button signInButtonId;

    Database database = new Database();
    User user = new User();
    Object userRole = new Object();
    public String role = "";

    @FXML
    void initialize() {
        signInButtonId.setOnAction(actionEvent -> {
            String login = loginTextId.getText().trim();
            String password = passwordTextId.getText().trim();
            if (!login.equals("") && !password.equals("")) {
                try {
                    login(login, password);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Введите логин и пароль");
            }
        });
    }

    private void login(String login, String password) throws SQLException, ClassNotFoundException {
        Database database = new Database();
        database.getConnection();
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        ResultSet resultSet = database.encryptoPassword(user);
        if (resultSet.next()) {

            role = resultSet.getString(1);
            signInButtonId.getScene().getWindow().hide();
            if (role.equals("admin")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainAdmin.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Главное окно");
                stage.showAndWait();
            } else if (role.equals("student")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainStudent.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Главное окно");
                stage.showAndWait();
            } else if (role.equals("prepod")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainPrepod.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                Parent root = fxmlLoader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle("Главное окно");
                stage.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Сообщение об ошибке");
            alert.setHeaderText("Ошибка!");
            alert.setContentText("Введите правильные логин или пароль");
            alert.showAndWait();
        }
    }
}