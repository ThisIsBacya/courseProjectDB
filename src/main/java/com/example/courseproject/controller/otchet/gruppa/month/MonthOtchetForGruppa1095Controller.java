package com.example.courseproject.controller.otchet.gruppa.month;

import com.example.courseproject.database.Database;
import com.example.courseproject.model.Otchet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MonthOtchetForGruppa1095Controller {
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
    ObservableList<Otchet> observableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        showData();
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fam_name_otch"));
        datePropuskColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        predmetColumn.setCellValueFactory(new PropertyValueFactory<>("nazv_predmeta"));
        kursColumn.setCellValueFactory(new PropertyValueFactory<>("kurs"));
        gruppaColumn.setCellValueFactory(new PropertyValueFactory<>("gruppa_nomer"));
        specColumn.setCellValueFactory(new PropertyValueFactory<>("nazvanie_profila"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableViewOtchetKurs.setItems(observableList);
    }

    private void showData() {
        try {
            connection = database.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * from getotchetfrommonthforgruppa1095");
            while (resultSet.next()) {
                String fam_name_otch = resultSet.getString("fam_name_otch");
                java.sql.Date data = resultSet.getDate("data");
                String nazv_predmeta = resultSet.getString("nazv_predmeta");
                int kurs = resultSet.getInt("kurs");
                String gruppa_nomer = resultSet.getString("gruppa_nomer");
                String nazvanie_profila = resultSet.getString("nazvanie_profila");
                String type = resultSet.getString("type");
                observableList.add(new Otchet(fam_name_otch, data, nazv_predmeta, kurs, gruppa_nomer, nazvanie_profila, type));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
