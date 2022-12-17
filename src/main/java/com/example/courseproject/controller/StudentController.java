package com.example.courseproject.controller;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class StudentController {

    @FXML
    private Label LabelStudentFIO;

    @FXML
    private Label LabelStudentGruppa;

    @FXML
    private Label LabelStudentKurs;

    @FXML
    private Label LabelStudentNomerStudBileta;

    @FXML
    private Label LabelsStudentSpec;

    @FXML
    private Button showAccountingMonth;

    @FXML
    private Button showAccountingMonthSemester;

    Database database = new Database();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        showAccountingMonth.setOnAction(actionEvent -> {
            return;
        });
        showAccountingMonthSemester.setOnAction(actionEvent -> {
            return;
        });
        Student student = new Student();
        database.getConnection();
        LabelStudentFIO.setText(student.getFam_name_otch());
    }
}