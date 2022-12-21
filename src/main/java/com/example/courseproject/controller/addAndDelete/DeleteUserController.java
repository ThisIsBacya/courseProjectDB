package com.example.courseproject.controller.addAndDelete;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Poseshaemost;
import com.example.courseproject.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class DeleteUserController {

    @FXML
    private Button clearButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField idUserField;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        database.getConnection();
        deleteButton.setOnAction(actionEvent -> {
            String idUser = idUserField.getText();
            User user = new User(idUser);
            database.removeUser(user);
            System.out.println("Пользователь удален");
        });
        clearButton.setOnAction(actionEvent -> {
            idUserField.setText(null);
        });
    }
}
