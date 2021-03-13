package com.company.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements IDB { // if we connect to Postgres DB we should use this class
    private static DatabaseConnection instance;
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/clothes_store";
        try {
            Class.forName("org.postgresql.Driver");  //load driver's class file into memory at the runtime
            return DriverManager.getConnection(connectionURL, "postgres", "1234");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    private DatabaseConnection(){};

    public static DatabaseConnection getInstance() throws SQLException {//applying here singleton to checking if instance is null we creating new, otherwise returning old instance
        if (instance == null) {//if we didn't create it earlier
            instance = new DatabaseConnection();//we create new one
        }
        return instance;//otherwise it returns old one
    }
}