package com.example.courseproject.controller;

import com.example.courseproject.database.Database;
import com.example.courseproject.database.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLoginController {
    @FXML
    private TextField inputTextId;

    @FXML
    private Button nextButtonId;

    @FXML
    private ImageView backbuttonId;

    @FXML
    void initialize() {
        nextButtonId.setOnAction(actionEvent -> {
            String nomerStudBilet = inputTextId.getText().trim();
            if (!nomerStudBilet.equals("")) {
                try {
                    loginStudent(nomerStudBilet);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void loginStudent(String nomerStudBilet) throws SQLException, ClassNotFoundException {
        Database database = new Database();
        Student student = new Student();
        student.setNomer_stud_bilet(nomerStudBilet);
        database.getConnection();
        ResultSet resultSet = database.getNomerStudBilet(student);

       if(resultSet.next()) { //TODO:
           System.out.println("Success");
       }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Сообщение об ошибке");
            alert.setHeaderText("Ошибка!");
            alert.setContentText("Вы ввели неправильный номер студенческого билета!");
            alert.showAndWait();
        }
    }
}
