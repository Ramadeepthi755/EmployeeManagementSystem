package controller;

import java.io.IOException;
import java.util.List;

import dao.UserDAO;
import model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/viewUsers")
public class ViewUserServlet extends HttpServlet {

	protected void doGet(
	        HttpServletRequest request,
	        HttpServletResponse response)

	        throws ServletException, IOException {

	    UserDAO dao = new UserDAO();

	    String keyword =
	            request.getParameter("keyword");

	    List<User> list;

	    if(keyword != null &&
	       !keyword.trim().isEmpty()) {

	        list = dao.searchUsers(keyword);

	    } else {

	        int page = 1;
	        int recordsPerPage = 5;

	        if(request.getParameter("page") != null) {

	            page = Integer.parseInt(
	                    request.getParameter("page"));
	        }

	        int start =
	                (page - 1) * recordsPerPage;

	        list =
	                dao.getUsersByPage(
	                        start,
	                        recordsPerPage);

	        request.setAttribute(
	                "currentPage",
	                page);
	    }

	    request.setAttribute(
	            "userList",
	            list);

	    request.getRequestDispatcher(
	            "view_users.jsp")
	            .forward(request, response);
	}
}