package com.abc.Services;

import com.abc.DBConnection.DBConnection;
import com.abc.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {

    public static int getNextID() {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(id) FROM Users;");
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) + 1;
            } else {
                return 1;
            }
        } catch (Exception e) {
            return 1;
        }
    }

    public static boolean addUser(User user) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (name,mobile,email,address) values(?,?,?,?)");
            statement.setString(1, user.getName());
            statement.setInt(2, user.getMobile());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAddress());

            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(1), rs.getInt(3), rs.getString(4), rs.getString(5)));
            }
            return users;
        } catch (Exception e) {
            return users;
        }
    }

    public static User getUserById(int id) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE id=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(1), rs.getInt(3), rs.getString(4), rs.getString(5));
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            return null;
        }
    }
}
