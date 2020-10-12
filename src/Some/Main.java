package Some;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:E:\\Databases\\" + DB_NAME;

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM albums");
            while (result.next()) {
                int id = result.getInt("_id");
                String name = result.getString("name");
                int artist = result.getInt("artist");
                System.out.println(id + name + artist);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
