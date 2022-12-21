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

public class AdminLoginController {

    @FXML
    private TextField loginTextId;


    @FXML
    private PasswordField passwordTextId;

    @FXML
    private Button signInButtonId;
    @FXML
    void initialize() {
        signInButtonId.setOnAction(actionEvent -> {
            String login = loginTextId.getText().trim();
            String password = passwordTextId.getText().trim();
            if(!login.equals("") && !password.equals("")) {
                try {
                    loginAdmin(login, password);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                System.out.println("Введите логин и пароль");
            }
        });
    }

    private void loginAdmin(String login, String password) throws SQLException, ClassNotFoundException {
       Database database = new Database();
       database.getConnection();
       User user = new User();
       user.setLogin(login);
       user.setPassword(password);
       ResultSet resultSet = database.getLoginAdmin(user);

       if (resultSet.next()) {
           signInButtonId.getScene().getWindow().hide();
           FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
           try {
               fxmlLoader.load();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           Stage stage = new Stage();
           Parent root = fxmlLoader.getRoot();
           stage.setScene(new Scene(root));
           stage.setTitle("Окно администратора");
           stage.showAndWait();
       }
    }
}
