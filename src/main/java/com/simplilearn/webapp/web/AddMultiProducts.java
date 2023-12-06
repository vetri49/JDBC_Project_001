package com.simplilearn.webapp.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.simplilearn.webapp.DB.DataBaseConnection;

@WebServlet("/add-multiproducts")
public class AddMultiProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set content type
		response.setContentType("text/html");
		response.sendRedirect("add-multiproducts.jsp");

	}

	/**
	 * This doPost handle form submission.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// collect input parameters
		String productName1 = request.getParameter("product_name1");
		String productDec1 = request.getParameter("product_desc1");
		String productPrice1 = request.getParameter("product_price1");
		
		String productName2 = request.getParameter("product_name2");
		String productDec2 = request.getParameter("product_desc2");
		String productPrice2 = request.getParameter("product_price2");
		
		String productName3 = request.getParameter("product_name3");
		String productDec3 = request.getParameter("product_desc3");
		String productPrice3 = request.getParameter("product_price3");
		
		DataBaseConnection db = null;
		
		try {
			// step 1: create connection
			db = new DataBaseConnection();
			Connection connection = db.init();
			
			// start a trasaction 
			connection.setAutoCommit(false);
			
			// step 2: create statement and execute query 
			String query1 = "INSERT into eproducts(product_name, product_desc, price) values('" 
							+productName1 +"','" +productDec1+"'," +productPrice1 +")";
			
			String query2 = "INSERT into eproducts(product_name, product_desc, price) values('" 
					+productName2 +"','" +productDec2+"'," +productPrice2 +")";
			
			String query3 = "INSERT into eproducts(product_name, product_desc, price) values('" 
					+productName3 +"','" +productDec3+"'," +productPrice3 +")";
			
			 db.executeUpdate(query1);
			 db.executeUpdate(query2);
			 db.executeUpdate(query3);
			
			// end a trasaction
			 connection.commit();
			 
			request.getRequestDispatcher("index.jsp").include(request, response);
			
			
			out.println("<h2> Multiple Product are created sucessfully ! </h2>");
			
		} catch (Exception e) {
			 e.printStackTrace();
			out.println("<h2> Exception Occured </h2>");
		} finally {
			out.close();
			db.close();
		}
	}


}
