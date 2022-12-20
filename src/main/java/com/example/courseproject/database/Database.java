package com.example.courseproject.database;

import com.example.courseproject.model.*;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

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

    public void addProfile(Profile profile) {
        String insert = "INSERT INTO " + Const.PROFILE_TABLE + "(" + Const.PROFILE_NAZVANIE_PROFILA + ")"
                + "VALUES (?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1, profile.getNazvanie_profila());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPredmet(Predmet predmet) {
        String insert = "INSERT INTO " + Const.PREDMET_TABLE + "(" + Const.PREDMET_NAZV_PREDMETA + "," + Const.PREDMET_CHASI + ")"
                + "VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1, predmet.getNazv_predmeta());
            preparedStatement.setInt(2, predmet.getChasi());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void addGruppa(Gruppa gruppa) {
        String insert = "INSERT INTO " + Const.GRUPPA_TABLE + "(" + Const.GRUPPA_NOMER + "," +
                Const.GRUPPA_GOD_POSTUPLENIA + "," + Const.GRUPPA_PROFILE_ID + "," + Const.GRUPPA_FORMA_OBUCHENIA + ")" +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1, gruppa.getGruppa_nomer());
            preparedStatement.setInt(2, gruppa.getGod_postuplenia());
            preparedStatement.setInt(3, gruppa.getProfile_id());
            preparedStatement.setString(4, gruppa.getForma_obuchenia());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPoseshaemost(Poseshaemost poseshaemost) {
        String insert = "INSERT INTO " + Const.POSESHAEMOST_TABLE + "(" + Const.POSESHAEMOST_DATA + "," + Const.POSESHAEMOST_STUDENTS_ID + "," +
            Const.PREDMET_ID + "," + Const.POSESHAEMOST_CHASI_PROPUSKA + "," + Const.POSESHAEMOST_TYPE + ")" + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setDate(1, poseshaemost.getData());
            preparedStatement.setInt(2, poseshaemost.getStudents_id());
            preparedStatement.setInt(3, poseshaemost.getPredmet_id());
            preparedStatement.setInt(4, poseshaemost.getChasi_propuska());
            preparedStatement.setString(5, poseshaemost.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
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

    public void removeGruppa(Gruppa gruppa) {
        String delete = "DELETE FROM " + Const.GRUPPA_TABLE + " WHERE " + Const.GRUPPA_ID + "=?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.setInt(1, gruppa.getGruppa_id());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeProfile(Profile profile) {
        String delete = "DELETE FROM " + Const.PROFILE_TABLE + " WHERE " + Const.PROFILE_ID + "=?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.setInt(1, profile.getProfile_id());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void removePredmet(Predmet predmet) {
        String delete = "DELETE FROM " + Const.PREDMET_TABLE + " WHERE " + Const.PREDMET_ID + "=?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.setInt(1, predmet.getPredmet_id());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getNazvProfile() throws SQLException {
        List<String> list = new ArrayList<>();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT nazvanie_profila FROM profile");
        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public List<String> getGruppaNomer() throws SQLException {
        List<String> list = new ArrayList<>();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT gruppa_nomer FROM gruppa");
        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public List<String> getGruppa() throws SQLException {
        List<String> list = new ArrayList<>();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT gruppa_nomer FROM gruppa");
        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public List<Otchet> getSpecPovtOtchetSemestr() throws SQLException {

        List<Otchet> list = new ArrayList<>();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from getotchetfromsemestrforspecpovt");
        while (resultSet.next()) {
            String fam_name_otch = resultSet.getString(1);
            Date data = resultSet.getDate(2);
            String nazv_predmeta = resultSet.getString(3);
            int kurs = resultSet.getInt(4);
            String gruppa_nomer = resultSet.getString(5);
            String nazvanie_profila = resultSet.getString(6);
            String type = resultSet.getString(7);
            list.add(new Otchet(fam_name_otch, data, nazv_predmeta, kurs, gruppa_nomer, nazvanie_profila, type));
        }
        return list;
    }

    public List<Otchet> getSpecAndroidOtchetSemestr() throws SQLException {

        List<Otchet> list = new ArrayList<>();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from getotchetfromsemestrforspecmobile");
        while (resultSet.next()) {
            String fam_name_otch = resultSet.getString(1);
            Date data = resultSet.getDate(2);
            String nazv_predmeta = resultSet.getString(3);
            int kurs = resultSet.getInt(4);
            String gruppa_nomer = resultSet.getString(5);
            String nazvanie_profila = resultSet.getString(6);
            String type = resultSet.getString(7);
            list.add(new Otchet(fam_name_otch, data, nazv_predmeta, kurs, gruppa_nomer, nazvanie_profila, type));
        }
        return list;
    }


//
//
//    public ResultSet getStudentInfo(String nomerStudBilet) {
//        ResultSet resultSet = null;
//        Student student = new Student();
//        String select = "SELECT * FROM " + Const.STUDENTS_TABLE + " WHERE " + Const.STUDENTS_STUDBILET + " = '" + nomerStudBilet + "'";
//        try {
//            PreparedStatement preparedStatement = dbConnection.prepareStatement(select);
//            resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//            System.out.println(resultSet.getString("fam_name_otch"));
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(select);
//        return resultSet;
//    }
}