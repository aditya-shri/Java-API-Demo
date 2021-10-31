package com.abc.Controllers;

import com.abc.Constants.JsonStrings;
import com.abc.Models.User;
import com.abc.Services.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            int mobile = Integer.parseInt(request.getParameter("mobile"));
            String email = request.getParameter("email");
            String address = request.getParameter("address");

            User user = new User(name, mobile, email, address);
            if (UserDAO.addUser(user)) {
                request.setAttribute("response", JsonStrings.addUser());
            } else {
                request.setAttribute("response", JsonStrings.error("User Addition failed"));
            }
        } catch (Exception e) {
            request.setAttribute("response", JsonStrings.error(e.toString()));
        }
        RequestDispatcher rq = request.getRequestDispatcher("response.jsp");
        rq.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<User> users = UserDAO.getAllUsers();
            String res = JsonStrings.getAllUsers(users);

            request.setAttribute("response", res);
        } catch (Exception e) {
            request.setAttribute("response", JsonStrings.error(e.toString()));
        }
        RequestDispatcher rq = request.getRequestDispatcher("response.jsp");
        rq.forward(request, response);
    }
}
