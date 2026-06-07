package controller;

import java.io.IOException;
import jakarta.servlet.http.*;

import dao.AdminDAO;
import util.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        AdminDAO dao =
                new AdminDAO();

        boolean status =
                dao.validateAdmin(
                        username,
                        password);

        if(status) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "admin",
                    username);

            response.sendRedirect(
                    "admin_dashboard.jsp");
        }else {

            response.sendRedirect(
                    "admin_login.jsp");
        }
    }
}