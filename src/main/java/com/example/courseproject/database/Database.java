package com.example.courseproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Database {
    private final static String DB_URL = "jdbc:postgresql://172.20.8.18/kp0091_06";
    private final static String DB_USER = "st0091";
    private final static String DB_PASSWORD = "qwerty91";

    Connection dbConnection;

    public Connection getConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        return dbConnection;
    }

//    public void signUpStudent() {
//        String insert = "INSERT INTO " + Const.STUDENTS_TABLE + "(" +
//
//    }

    public ResultSet getNomerStudBilet(Student student) {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.STUDENTS_TABLE + " WHERE " +
                Const.STUDENTS_STUDBILET + "=?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(select);
            preparedStatement.setString(1, student.getNomer_stud_bilet());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}

