package com.example.courseproject.controller.addAndDelete;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddUserController {

    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField lognField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ComboBox<String> comboBoxRole;

    Database database = new Database();

    @FXML
    private TextField rolTxtFld;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        database.getConnection();
        String[] items = {"admin", "student", "prepod"};
        comboBoxRole.getItems().addAll(items);
        addButton.setOnAction(actionEvent -> {
            String login = lognField.getText();
            String password = passwordField.getText();
            String role = comboBoxRole.getSelectionModel().getSelectedItem();
            User user = new User(login, password, role);
            database.addUser(user);
            System.out.println("Пользователь добавлен");
        });
        clearButton.setOnAction(actionEvent -> {
            lognField.setText(null);
            passwordField.setText(null);
        });
    }
}
