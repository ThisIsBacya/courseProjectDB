package com.example.courseproject.controller.addAndDelete;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Gruppa;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddGruppaController {

    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField formaObucheniaField;

    @FXML
    private TextField godPostupleniaField;

    @FXML
    private TextField gruppaNomerField;

    @FXML
    private TextField profileIdField;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        database.getConnection();
        addButton.setOnAction(actionEvent -> {
            String gruppaNomer = gruppaNomerField.getText();
            int profileId = Integer.parseInt(profileIdField.getText());
            int gopPostuplenia = Integer.parseInt(godPostupleniaField.getText());
            String formaObuchenia = formaObucheniaField.getText();
            Gruppa gruppa = new Gruppa(gruppaNomer, profileId, gopPostuplenia, formaObuchenia);
            database.addGruppa(gruppa);
            System.out.println("Группа добавлена");
        });
        clearButton.setOnAction(actionEvent -> {
            gruppaNomerField.setText(null);
            profileIdField.setText(null);
            godPostupleniaField.setText(null);
            formaObucheniaField.setText(null);
        });
    }
}
