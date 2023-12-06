package com.simplilearn.webapp.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.simplilearn.webapp.DB.DataBaseConnection;

/**
 * Servlet implementation class Initcontroller
 */
@WebServlet("/init-connection")
public class Initcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		 response.setContentType("text/html");
		// response.sendRedirect("index.jsp");
		 PrintWriter out=response.getWriter();
		 DataBaseConnection con=new DataBaseConnection();
		 con.jdbcOperation();
		 out.print("<h1>Connection was established</h1>");
	}

}
