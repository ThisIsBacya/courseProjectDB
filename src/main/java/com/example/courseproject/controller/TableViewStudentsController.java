package com.example.courseproject.controller;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableViewStudentsController {
    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> fioColumn;

    @FXML
    private TableColumn<Student, Integer> gruppaIdColumn;

    @FXML
    private TableColumn<Student, String> nomerStudBiletColumn;

    @FXML
    private TableColumn<Student, Integer> kursColumn;

    @FXML
    private TableView<Student> studentsTable;

    Database database = new Database();

    ObservableList<Student> observableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        showData();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("students_id"));
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fam_name_otch"));
        gruppaIdColumn.setCellValueFactory(new PropertyValueFactory<>("gruppa_id"));
        nomerStudBiletColumn.setCellValueFactory(new PropertyValueFactory<>("nomer_stud_bilet"));
        kursColumn.setCellValueFactory(new PropertyValueFactory<>("kurs"));
        studentsTable.setItems(observableList);
    }

    private void showData() {
        try {
            Connection connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                observableList.add(new Student(resultSet.getInt("students_id"), resultSet.getString("fam_name_otch"),
                        resultSet.getInt("gruppa_id"), resultSet.getString("nomer_stud_bilet"), resultSet.getInt("kurs")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
