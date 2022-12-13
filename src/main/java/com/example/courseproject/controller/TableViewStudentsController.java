package com.example.courseproject.controller;

import com.jfoenix.controls.JFXButton;
import com.example.courseproject.HelloApplication;
import com.example.courseproject.database.Database;
import com.example.courseproject.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
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


    @FXML
    private JFXButton addStudent;

    @FXML
    private JFXButton update;

    @FXML
    private JFXButton delete;



    Database database = new Database();
    Connection connection = null;

    ObservableList<Student> observableList = FXCollections.observableArrayList();

    @FXML
    void getAddView(MouseEvent event) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addStudent.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Добавить студента");
            stage.showAndWait();
    }

    @FXML
    void initialize() {
        showData();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("students_id"));
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fam_name_otch"));
        gruppaIdColumn.setCellValueFactory(new PropertyValueFactory<>("gruppa_id"));
        nomerStudBiletColumn.setCellValueFactory(new PropertyValueFactory<>("nomer_stud_bilet"));
        kursColumn.setCellValueFactory(new PropertyValueFactory<>("kurs"));
        studentsTable.setItems(observableList);

        addStudent.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addStudent.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Добавить студента");
            stage.showAndWait();
        });
        update.setOnAction(actionEvent -> {
            observableList.clear();
            try {
                ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM students");
                while (resultSet.next()) {
                    observableList.add(new Student(resultSet.getInt("students_id"), resultSet.getString("fam_name_otch"),
                            resultSet.getInt("gruppa_id"), resultSet.getString("nomer_stud_bilet"), resultSet.getInt("kurs")));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            };
        });
        delete.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("deleteStudent.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            Parent root = fxmlLoader.getRoot();
            stage.setScene(new Scene(root));
            stage.setTitle("Удалить студента");
            stage.showAndWait();
        });
    }

    private void showData() {
        try {
            connection = database.getConnection();
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