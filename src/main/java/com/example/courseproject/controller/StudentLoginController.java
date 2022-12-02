package com.example.courseproject.controller;

import com.example.courseproject.HelloApplication;
import com.example.courseproject.database.Database;
import com.example.courseproject.database.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLoginController {
    @FXML
    private Button backButton;

    @FXML
    private Button backButtonId;

    @FXML
    private TextField inputTextId;

    @FXML
    private Button nextButtonId;

    public StudentLoginController() {
    }

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

       if(resultSet.next()) {
           nextButtonId.getScene().getWindow().hide();
           FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("student.fxml"));
           try {
               fxmlLoader.load();
           } catch (IOException e) {
               throw new RuntimeException();
           }
           Stage stage = new Stage();
           Parent root = fxmlLoader.getRoot();
           stage.setScene(new Scene(root));
           stage.setTitle("Студент");
           stage.showAndWait();
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
