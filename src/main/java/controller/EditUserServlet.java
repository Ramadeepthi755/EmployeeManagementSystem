package controller;

import java.io.IOException;

import dao.UserDAO;
import model.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        int id =
                Integer.parseInt(
                request.getParameter("id"));

        UserDAO dao =
                new UserDAO();

        User user =
                dao.getUserById(id);

        request.setAttribute(
                "user",
                user);

        request.getRequestDispatcher(
                "edit_user.jsp")
                .forward(request, response);
    }
}