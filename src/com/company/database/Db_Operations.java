package com.company.database;

import java.sql.*;

public class Db_Operations {

    private static String db = "fms";
    private static String user = "root";
    private static String password = "Sameer2205";

    public static Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
        return connection;
    }

    public static void insert(String query) {
        Connection con;
        PreparedStatement insert;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
            insert = con.prepareStatement(query);
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet read(String query) {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

