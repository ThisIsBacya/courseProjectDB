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

public class SeptemberQueryController {

    @FXML
    private TableView<Queries> tableViewQuery;

    @FXML
    private TableColumn<Queries, String> fioColumn;

    @FXML
    private TableColumn<Queries, String> predmetColumn;

    @FXML
    private TableColumn<Queries, Date> dataColumn;

    Database database = new Database();
    Connection connection = null;

    ObservableList<Queries> observableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        showData();
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fam_name_otch"));
        predmetColumn.setCellValueFactory(new PropertyValueFactory<>("nazv_predmeta"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableViewQuery.setItems(observableList);
    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT fam_name_otch, nazv_predmeta, data FROM predmet " +
                    "INNER JOIN poseshaemost on predmet.predmet_id = poseshaemost.predmet_id " +
                    "INNER JOIN students s on s.students_id = poseshaemost.students_id " +
                    "WHERE data > '2022-09-01';");
            while (resultSet.next()) {
                observableList.add(new Queries(resultSet.getString("fam_name_otch"), resultSet.getString("nazv_predmeta"), resultSet.getDate("data")));
                System.out.println(observableList);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
