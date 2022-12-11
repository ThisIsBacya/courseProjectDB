package com.example.courseproject.controller;

import com.example.courseproject.model.Poseshaemost;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Date;

public class TableViewPoseshaemostController {

    @FXML
    private TableView<Poseshaemost> tableViewPoseshaemost;

    @FXML
    private TableColumn<Poseshaemost, Integer> poseshaemostIdColumn;

    @FXML
    private TableColumn<Poseshaemost, Date> datePropuskColumn;

    @FXML
    private TableColumn<Poseshaemost, Integer> predmetIdColumn;

    @FXML
    private TableColumn<Poseshaemost, Integer> studentsIdColumn;

    @FXML
    private TableColumn<Poseshaemost, String> typeColumn;

}
