package com.example.courseproject.database;

import com.example.courseproject.model.Gruppa;
import com.example.courseproject.model.Student;
import com.example.courseproject.model.User;

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

    //Логин для студента
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

    //Логин для админа
    public ResultSet getLoginAdmin(User user) {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " +
                Const.USERS_LOGIN + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(select);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void addStudent(Student student) {
        String insert = "INSERT INTO " + Const.STUDENTS_TABLE + "(" + Const.STUDENTS_FAM_NAME_OTCH + "," +
                Const.STUDENTS_GRUPPAID + "," + Const.STUDENTS_STUDBILET + "," + Const.STUDENTS_KURS + ")" +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1, student.getFam_name_otch());
            preparedStatement.setInt(2, student.getGruppa_id());
            preparedStatement.setString(3, student.getNomer_stud_bilet());
            preparedStatement.setInt(4, student.getKurs());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeStudent(Student student) {
        String delete = "DELETE FROM " + Const.STUDENTS_TABLE + " WHERE " + Const.STUDENTS_ID + " =?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.setInt(1, student.getStudents_id());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet getStudentInfo(Student student, Gruppa gruppa) {
        ResultSet resultSet = null;
        String select = "SELECT " + Const.STUDENTS_FAM_NAME_OTCH + ", " + Const.GRUPPA_NOMER + " FROM " + Const.STUDENTS_TABLE
                + " INNER JOIN " + Const.GRUPPA_TABLE + " ON " + Const.STUDENTS_GRUPPAID + " = " + Const.GRUPPA_ID;
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(select);
            preparedStatement.executeQuery();


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}

