package controller;

import java.io.IOException;

import dao.UserDAO;
import model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        UserDAO dao =
                new UserDAO();

        User user =
                dao.validateUser(
                        username,
                        password);

        if(user != null) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "user",
                    user);

            if("ADMIN".equalsIgnoreCase(
                    user.getRole())) {

                response.sendRedirect(
                        "admin_dashboard.jsp");

            } else {

                response.sendRedirect(
                        "user_dashboard.jsp");
            }

        } else {

            response.sendRedirect(
                    "user_login.jsp");
        }
    }
}