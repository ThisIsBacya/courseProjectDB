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

public class MultiTableQueryController {

    @FXML
    private TableView<Queries> tableViewQuery;

    @FXML
    private TableColumn<Queries, String> fioColumn;

    @FXML
    private TableColumn<Queries, String> gruppaNomerColumn;

    Database database = new Database();
    Connection connection = null;

    ObservableList<Queries> observableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        showData();
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fam_name_otch"));
        gruppaNomerColumn.setCellValueFactory(new PropertyValueFactory<>("gruppa_nomer"));
        tableViewQuery.setItems(observableList);
    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT fam_name_otch, gruppa_nomer FROM students INNER JOIN gruppa g on g.gruppa_id = students.gruppa_id");
            while (resultSet.next()) {
                observableList.add(new Queries(resultSet.getString("fam_name_otch"), resultSet.getString("gruppa_nomer")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
