package controller;
import org.mindrot.jbcrypt.BCrypt;
import java.io.IOException;

import dao.UserDAO;
import model.User;

import java.io.File;
import util.EmailUtil;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addUser")
@MultipartConfig
public class AddUserServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        User user = new User();

        user.setFullname(
                request.getParameter("fullname"));

        user.setEmail(
                request.getParameter("email"));

        user.setPhone(
                request.getParameter("phone"));

        user.setUsername(
                request.getParameter("username"));
        String password =
                request.getParameter("password");

        String hashedPassword =
                BCrypt.hashpw(
                        password,
                        BCrypt.gensalt());

        user.setPassword(
                hashedPassword);
        
        Part filePart =
                request.getPart("image");

        String fileName =
                filePart.getSubmittedFileName();

        String uploadPath =
                getServletContext()
                .getRealPath("")
                + File.separator
                + "uploads";

        File uploadDir =
                new File(uploadPath);

        if(!uploadDir.exists()) {

            uploadDir.mkdir();
        }

        filePart.write(
                uploadPath
                + File.separator
                + fileName);

        user.setImage(fileName);

        UserDAO dao =
                new UserDAO();

        boolean status =
                dao.addUser(user);

        if(status) {
        	  System.out.println("User Added");
            EmailUtil.sendEmail(
                    user.getEmail(),
                    "Welcome to EMS",
                    "Hello "
                    + user.getFullname()
                    + ", your account has been created successfully.");
            System.out.println("Mail Sent");
            request.getRequestDispatcher(
                    "/success.jsp")
                    .forward(request, response);
        } else {
        	response.sendRedirect(
        	        request.getContextPath()
        	        + "/add_user.jsp");
        }
    }
}