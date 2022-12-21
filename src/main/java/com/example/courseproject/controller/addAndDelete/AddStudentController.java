package com.example.courseproject.controller.addAndDelete;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class AddStudentController {


    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField fioField;

    @FXML
    private TextField gruppaIdField;

    @FXML
    private TextField kursField;

    @FXML
    private TextField nomerStudBiletField;


    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        database.getConnection();
        addButton.setOnAction(actionEvent -> {
            String FIO = fioField.getText();
            int gruppaId = Integer.parseInt(gruppaIdField.getText());
            String nomerStudBilet = nomerStudBiletField.getText();
            int kurs = Integer.parseInt(kursField.getText());
            Student student = new Student(FIO, gruppaId, nomerStudBilet, kurs);
            database.addStudent(student);
            System.out.println("Студент добавлен");
        });
        clearButton.setOnAction(actionEvent -> {
            fioField.setText(null);
            gruppaIdField.setText(null);
            nomerStudBiletField.setText(null);
            kursField.setText(null);
        });
    }
}