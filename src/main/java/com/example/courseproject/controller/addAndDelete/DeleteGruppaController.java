package com.example.courseproject.controller.addAndDelete;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Gruppa;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class DeleteGruppaController {

    @FXML
    private Button clearButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField idGruppaField;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        database.getConnection();
        deleteButton.setOnAction(actionEvent -> {
            int idGruppa = Integer.parseInt(idGruppaField.getText());
            Gruppa gruppa = new Gruppa(idGruppa);
            database.removeGruppa(gruppa);
            System.out.println("Группа удалена!");
        });
    }
}
