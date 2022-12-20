package com.example.courseproject.controller.addAndDelete;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Profile;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class DeleteProfileController {

    @FXML
    private Button clearButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField idProfileField;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        database.getConnection();
        deleteButton.setOnAction(actionEvent -> {
            int idProfile = Integer.parseInt(idProfileField.getText());
            Profile profile = new Profile(idProfile);
            database.removeProfile(profile);
            System.out.println("Профиль удалён!");
        });
        idProfileField.setText(null);
    }
}