package com.abc.DBConnection;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");

            URI dbUri = new URI("postgres://azccxipsgexchd:34d0525393cd5e97cc33f8e592c88678659542e5fa54d565aafef376eee8a6e5@ec2-34-200-161-87.compute-1.amazonaws.com:5432/d675d9pl17sr6q");
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ignored) {
        }
    }
}
