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

public class AggregateQueryController {
    @FXML
    private TableView<Queries> tableViewQuery;

    @FXML
    private TableColumn<Queries, Integer> maxColumn;

    Database database = new Database();
    Connection connection = null;

    ObservableList<Queries> observableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        showData();
        maxColumn.setCellValueFactory(new PropertyValueFactory<>("max"));
        tableViewQuery.setItems(observableList);
    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT MAX(chasi) from predmet;");
            while (resultSet.next()) {
                observableList.add(new Queries(resultSet.getInt("max")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
