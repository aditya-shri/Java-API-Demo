package com.abc.Services;

import com.abc.DBConnection.DBConnection;
import com.abc.Models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderDAO {

    public static boolean addOrder(Order order) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders (userid,item,description,quantity) values(?,?,?,?)");
            statement.setInt(1, order.getUserid());
            statement.setString(2, order.getItem().getName());
            statement.setString(3, order.getDescription());
            statement.setInt(4, order.getQuantity());

            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static ArrayList<Order> getAllOrdersByUser(int userid) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE userid=?");
            statement.setInt(1, userid);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Order order = new Order(rs.getInt(2), rs.getString(4), rs.getInt(5), rs.getString(3));
                orders.add(order);
            }
            return orders;
        } catch (Exception e) {
            return orders;
        }
    }

    public static boolean updateOrder(int userId, int orderId) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement("UPDATE Orders SET userid=? WHERE id=?");
            statement.setInt(1, userId);
            statement.setInt(2, orderId);

            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean deleteOrder(int userId, int orderId) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders WHERE userid=? AND id=?");
            statement.setInt(1, userId);
            statement.setInt(2, orderId);

            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
