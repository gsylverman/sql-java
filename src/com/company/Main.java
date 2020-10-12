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
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "(" +
                    COLUMN_NAME + " text, " +
                    COLUMN_PHONE + " integer, " +
                    COLUMN_EMAIL + " text)");
            createContact(statement, "George", 454646456, "george@yahoo.com");
            createContact(statement, "Andre", 7874546, "andrei@yahoo.com");
            createContact(statement, "Ramona", 3654545, "ramona@yahoo.com");
            statement.execute("UPDATE contacts SET email='someRandomemail@yahoo.com' WHERE email='george@yahoo.com'");
            statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE name='Andre'");
            statement.execute("SELECT * FROM " + TABLE_CONTACTS);
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                System.out.println(result.getString(COLUMN_NAME) + " " +
                        result.getInt(COLUMN_PHONE) + " " +
                        result.getString(COLUMN_EMAIL));
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL + ") " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
}
