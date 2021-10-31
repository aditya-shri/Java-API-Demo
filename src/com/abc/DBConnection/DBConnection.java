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

            URI dbUri = new URI("postgres://jojvufauqzdimz:bd6abab775eb8c639c1f4963aed2be4e457a695f1fd6b5d7fd667ddd3eb0e12b@ec2-34-206-220-95.compute-1.amazonaws.com:5432/dbsal3561trogb");
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            connection = DriverManager.getConnection(dbUrl,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ignored) {}
    }
}
