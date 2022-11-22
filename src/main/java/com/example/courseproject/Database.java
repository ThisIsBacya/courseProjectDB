package com.example.courseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final static String DB_URL = "jdbc:postgresql://172.20.8.18/db0091_06";
    private final static String DB_USER = "st0091";
    private final static String DB_PASSWORD = "qwerty91";

    public static void main(String[] args) {
        System.out.println("Идет поиск драйвера PostgreSQL JDBC.");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер PostgreSQL JDBC не найден.");
            e.printStackTrace();
            return;
        }
        System.out.println("Подключение к драйверу выполнено успешно.");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Подключение не удалось.");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            System.out.println("Вы успешно подключены к БД");
        } else {
            System.out.println("Подключение к БД не удалось");
        }
    }
}
