package com.company;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:E:\\Databases\\" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
//            connection.setAutoCommit(false);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME +
                    ", " + COLUMN_PHONE +
                    ", " + COLUMN_EMAIL + ")");
            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME +
                    ", " + COLUMN_PHONE +
                    ", " + COLUMN_EMAIL + ") " +
                    "VALUES('Jane', 1121221, 'jane@gmail.com')");
//            statement.execute("UPDATE contacts SET phone=10123546 "+
//                    "WHERE contacts.name='Jane'");
//            statement.execute("DELETE FROM contacts WHERE name='Grigore'");
            statement.execute("SELECT * FROM " + TABLE_CONTACTS);
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                System.out.println(result.getString("name") + " " +
                        result.getInt("phone") + " " +
                        result.getString("email"));
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }
}
