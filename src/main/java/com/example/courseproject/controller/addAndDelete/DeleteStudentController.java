package com.example.courseproject.controller.addAndDelete;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class DeleteStudentController {

    @FXML
    private Button clearButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField idStudentField;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        database.getConnection();
        deleteButton.setOnAction(actionEvent -> {
            int idStudent = Integer.parseInt(idStudentField.getText());
            Student student = new Student(idStudent);
            database.removeStudent(student);
            System.out.println("Студент удален");
        });
        idStudentField.setText(null);
    }
}