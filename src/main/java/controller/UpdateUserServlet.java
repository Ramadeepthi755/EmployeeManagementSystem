package controller;

import java.io.IOException;

import dao.UserDAO;
import model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        User user = new User();

        user.setId(
                Integer.parseInt(
                request.getParameter("id")));

        user.setFullname(
                request.getParameter("fullname"));

        user.setEmail(
                request.getParameter("email"));

        user.setPhone(
                request.getParameter("phone"));

        user.setUsername(
                request.getParameter("username"));

        user.setPassword(
                request.getParameter("password"));

        UserDAO dao =
                new UserDAO();

        boolean status =
                dao.updateUser(user);

        if(status) {

            response.sendRedirect(
                    "viewUsers");

        } else {

            response.sendRedirect(
                    "edit_user.jsp");
        }
    }
}