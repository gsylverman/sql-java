package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:E:\\Databases\\testjava.db");
            Statement statement = connection.createStatement();
//            connection.setAutoCommit(false);
            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
                    "(name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Jane', 1121221, 'jane@gmail.com')");
//            statement.execute("UPDATE contacts SET phone=10123546 "+
//                    "WHERE contacts.name='Jane'");
//            statement.execute("DELETE FROM contacts WHERE name='Grigore'");
            statement.execute("SELECT * FROM contacts");
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
