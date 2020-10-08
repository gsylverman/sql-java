package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:E:\\Databases\\testjava.db");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }
}
