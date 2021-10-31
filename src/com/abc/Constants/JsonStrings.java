package com.abc.Constants;

import com.abc.Models.Order;
import com.abc.Models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class JsonStrings {

    public static String error(String error) {
        return "{" +
                "    \"success\": false,\n" +
                "    \"message\": \""+error+"\",\n" +
                "}";
    }

    public static String addUser() {
        return "{" +
                "    \"success\": true,\n" +
                "    \"message\": \"User data successfully added\",\n" +
                "}";
    }

    public static String addOrder() {
        return "{" +
                    "    \"success\": true,\n" +
                    "    \"message\": \"Order successfully added\",\n" +
                    "}";
    }

    public static String getAllOrders(ArrayList<Order> orders) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();


        String res =  "{" +
                    "    \"success\": true,\n" +
                    "    \"message\": \"All orders for the user asked!\",\n" +
                    "    \"data\": [";

        for(Order order: orders){
            String json = gson.toJson(order);
        }

        res += "]}";
        return res;
    }

    public static String updateOrder() {
        return "{" +
                "    \"success\": true,\n" +
                "    \"message\": \"Order updated successfully\",\n" +
                "}";
    }

    public static String deleteOrder() {
        return "{" +
                "    \"success\": true,\n" +
                "    \"message\": \"Order deletion successfully\",\n" +
                "}";
    }

    public static String getAllUsers(ArrayList<User> users) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();


        String res =  "{" +
                "    \"success\": true,\n" +
                "    \"message\": \"All Users!\",\n" +
                "    \"data\": [";

        for(User user: users){
            String json = gson.toJson(user);
        }

        res += "]}";
        return res;
    }
}
