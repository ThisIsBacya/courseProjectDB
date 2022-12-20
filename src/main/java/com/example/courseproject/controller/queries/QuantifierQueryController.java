package com.example.courseproject.controller.queries;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Queries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuantifierQueryController {

    @FXML
    private TableView<Queries> tableViewQuery;

    @FXML
    private TableColumn<Queries, Integer> idColumn;

    @FXML
    private TableColumn<Queries, String> fioColumn;

    @FXML
    private TableColumn<Queries, String> nomerStudBiletColumn;

    @FXML
    private TableColumn<Queries, Integer> kursColumn;

    Database database = new Database();
    Connection connection = null;

    ObservableList<Queries> observableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        showData();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("students_id"));
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fam_name_otch"));
        nomerStudBiletColumn.setCellValueFactory(new PropertyValueFactory<>("nomer_stud_bilet"));
        kursColumn.setCellValueFactory(new PropertyValueFactory<>("kurs"));
        tableViewQuery.setItems(observableList);
    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT students_id, fam_name_otch, nomer_stud_bilet, kurs FROM students WHERE EXISTS(SELECT 1 FROM gruppa WHERE gruppa.gruppa_id = students.gruppa_id)");
            while (resultSet.next()) {
                observableList.add(new Queries(resultSet.getInt("students_id"), resultSet.getString("fam_name_otch"),
                        resultSet.getString("nomer_stud_bilet"), resultSet.getInt("kurs")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
