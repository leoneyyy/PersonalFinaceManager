package com.projekt.personalfinacemanager.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/finanzmanager";
    private static final String USER = "root";


    private static  String PASSWORD = "";
    static {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
            PASSWORD = props.getProperty("db.password");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }



    public static Connection connect(){
        try {
            Connection connection = java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (java.sql.SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
            return null;
        }

    }

}
