package Some;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:E:\\Databases\\testjava.db");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM contacts");
            while (result.next()) {
                String name = result.getString("name");
                int phone = result.getInt("phone");
                String email = result.getString("email");
                System.out.println("Name: " + name + " phone: " + phone + " email: " + email);
            }
            result.close();
            statement.close();

            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
