package com.abc.Controllers;

import com.abc.Constants.JsonStrings;
import com.abc.Models.Order;
import com.abc.Services.OrderDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userid = Integer.parseInt(request.getParameter("userid"));
            String description = request.getParameter("description");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String item = request.getParameter("item");

            Order order = new Order(userid, description, quantity, item);

            if (OrderDAO.addOrder(order)) {
                request.setAttribute("response", JsonStrings.addOrder());
            } else {
                request.setAttribute("response", JsonStrings.error("Order addition failed!"));
            }
        } catch (Exception e) {
            request.setAttribute("response", JsonStrings.error(e.toString()));
        }

        RequestDispatcher rq = request.getRequestDispatcher("response.jsp");
        rq.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userid = Integer.parseInt(request.getParameter("userid"));

            ArrayList<Order> orders = OrderDAO.getAllOrdersByUser(userid);
            String res = JsonStrings.getAllOrders(orders);

            request.setAttribute("response", res);
        } catch (Exception e) {
            request.setAttribute("response", JsonStrings.error(e.toString()));
        }
        RequestDispatcher rq = request.getRequestDispatcher("response.jsp");
        rq.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(request.getParameter("userid"));
            int orderId = Integer.parseInt(request.getParameter("id"));

            if (OrderDAO.updateOrder(userId, orderId)) {
                request.setAttribute("response", JsonStrings.updateOrder());
            } else {
                request.setAttribute("response", JsonStrings.error("Order update failed!"));
            }
        } catch (Exception e) {
            request.setAttribute("response", JsonStrings.error(e.toString()));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(request.getParameter("userid"));
            int orderId = Integer.parseInt(request.getParameter("id"));

            if (OrderDAO.deleteOrder(userId, orderId)) {
                request.setAttribute("response", JsonStrings.deleteOrder());
            } else {
                request.setAttribute("response", JsonStrings.error("Order deletion failed!"));
            }
        } catch (Exception e) {
            request.setAttribute("response", JsonStrings.error(e.toString()));
        }
    }
}
