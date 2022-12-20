package com.example.courseproject.controller.addAndDelete;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Predmet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class DeletePredmetController {

    @FXML
    private Button clearButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField idPredmetField;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        database.getConnection();
        deleteButton.setOnAction(actionEvent -> {
                int idPredmet = Integer.parseInt(idPredmetField.getText());
                Predmet predmet = new Predmet(idPredmet);
                database.removePredmet(predmet);
                System.out.println("Предмет удален");
        });
    }
}