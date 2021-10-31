package com.abc.Services;

import com.abc.DBConnection.DBConnection;
import com.abc.Models.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemDAO {

    public static Item getItem(String item) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Items WHERE name=?");
            statement.setString(1, item);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Item(rs.getString(1), rs.getString(2), rs.getInt(3));
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            return null;
        }
    }
}
