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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleQueryController {

    @FXML
    private TableView<Queries> tableViewQuery;

    @FXML
    private TableColumn<Queries, Integer> queryIdColumn;

    @FXML
    private TableColumn<Queries, Date> querydDatePropuskColumn;

    @FXML
    private TableColumn<Queries, Integer> queryChasiColumn;

    @FXML
    private TableColumn<Queries, Integer> queryStudentsIdColumn;

    @FXML
    private TableColumn<Queries, Integer> queryPredmetIdColumn;

    @FXML
    private TableColumn<Queries, String> queryTypeColumn;

    Database database = new Database();
    Connection connection = null;

    ObservableList<Queries> observableList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        showData();
        queryIdColumn.setCellValueFactory(new PropertyValueFactory<>("poseshaemost_id"));
        querydDatePropuskColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        queryStudentsIdColumn.setCellValueFactory(new PropertyValueFactory<>("students_id"));
        queryPredmetIdColumn.setCellValueFactory(new PropertyValueFactory<>("predmet_id"));
        queryChasiColumn.setCellValueFactory(new PropertyValueFactory<>("chasi_propuska"));
        queryTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableViewQuery.setItems(observableList);

    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM  poseshaemost where data between '01-01-2022' and current_date");
            while (resultSet.next()) {
                observableList.add(new Queries(resultSet.getInt("poseshaemost_id"), resultSet.getDate("data"),
                        resultSet.getInt("students_id"), resultSet.getInt("predmet_id"), resultSet.getInt("chasi_propuska"), resultSet.getString("type")) {
                });
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}