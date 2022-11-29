package com.example.courseproject.controller;

import com.example.courseproject.database.Database;
import com.example.courseproject.database.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepodLoginController {

    @FXML
    private TextField loginTextId;

    @FXML
    private TextField passwordTextId;

    @FXML
    private Button signInButtonId;

    void initialize() {
        signInButtonId.setOnAction(actionEvent -> {
            String login = loginTextId.getText().trim();
            String password = passwordTextId.getText().trim();
            if(!login.equals("") && !password.equals("")) {
                try {
                    loginPrepod(login, password);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void loginPrepod(String login, String password) throws SQLException, ClassNotFoundException {
        Database database = new Database();
        database.getConnection();
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        ResultSet resultSet = database.getLoginPrepod(user);

         if(resultSet.next()) {
            System.out.println("Success");
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Сообщение об ошибке");
            alert.setHeaderText("Ошибка!");
            alert.setContentText("Вы ввели неправильный логин или пароль!");
            alert.showAndWait();
        }
    }

}

