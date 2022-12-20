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

public class ScalarQueryController {

    @FXML
    private TableView<Queries> tableViewQuery;

    @FXML
    private TableColumn<Queries, Date> dataColumn;

    @FXML
    private TableColumn<Queries, String> fioColumn;

    @FXML
    private TableColumn<Queries, String> predmetColumn;

    @FXML
    private TableColumn<Queries, Integer> chasiColumn;

    @FXML
    private TableColumn<Queries, String> typeColumn;

    Database database = new Database();
    Connection connection = null;

    ObservableList<Queries> observableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        showData();
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fam_name_otch"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        predmetColumn.setCellValueFactory(new PropertyValueFactory<>("nazv_predmeta"));
        chasiColumn.setCellValueFactory(new PropertyValueFactory<>("chasi_propuska"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableViewQuery.setItems(observableList);
    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT fam_name_otch, data, nazv_predmeta, chasi_propuska, type FROM poseshaemost\n" +
                    "    INNER JOIN predmet on predmet.predmet_id = poseshaemost.predmet_id INNER JOIN students s on s.students_id = poseshaemost.students_id\n" +
                    "                                           group by data, chasi_propuska, nazv_predmeta, fam_name_otch, type\n" +
                    "                                                                   HAVING chasi_propuska < 4");
            while (resultSet.next()) {
                observableList.add(new Queries(resultSet.getString("fam_name_otch"), resultSet.getDate("data"),
                        resultSet.getString("nazv_predmeta"), resultSet.getInt("chasi_propuska"),
                        resultSet.getString("type")) {
                });
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
