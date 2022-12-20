package com.example.courseproject.controller.tableView;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Otchet;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class TableViewSpecSemestrController {

    @FXML
    TableView<Otchet> tableViewOtchetKurs;

    @FXML
    TableColumn<Otchet, String> fioColumn;

    @FXML
    TableColumn<Otchet, Date> datePropuskColumn;

    @FXML
    TableColumn<Otchet, Integer> kursColumn;

    @FXML
    TableColumn<Otchet, String> predmetColumn;

    @FXML
    TableColumn<Otchet, String> specColumn;


    @FXML
    private TableColumn<Otchet, String> gruppaColumn;

    @FXML
    TableColumn<Otchet, String> typeColumn;

    Database database = new Database();
    Connection connection = null;


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        showData();
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fam_name_otch"));
        datePropuskColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        predmetColumn.setCellValueFactory(new PropertyValueFactory<>("nazv_predmeta"));
        kursColumn.setCellValueFactory(new PropertyValueFactory<>("kurs"));
        gruppaColumn.setCellValueFactory(new PropertyValueFactory<>("gruppa_nomer"));
        specColumn.setCellValueFactory(new PropertyValueFactory<>("nazvanie_profila"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
    }

    private void showData() throws SQLException, ClassNotFoundException {
        connection = database.getConnection();
        database.getSpecOtchetSemestr();
    }

}
