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

public class TableQueryController {

    @FXML
    private TableView<Queries> tableViewQuery;

    @FXML
    private TableColumn<Queries, Date> dataColumn;

    @FXML
    private TableColumn<Queries, String> fioColumn;

    @FXML
    private TableColumn<Queries, String> predmetColumn;

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
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableViewQuery.setItems(observableList);

    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT fam_name_otch, data, nazv_predmeta, type FROM poseshaemost " +
                    "    INNER JOIN students s on s.students_id = poseshaemost.students_id\n" +
                    "    INNER JOIN predmet p on p.predmet_id = poseshaemost.predmet_id where type='уважительная';");
            while (resultSet.next()) {
                observableList.add(new Queries(resultSet.getString("fam_name_otch"), resultSet.getDate("data"), resultSet.getString("nazv_predmeta"),
                        resultSet.getString("type")));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
