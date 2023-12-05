package com.simplilearn.webapp.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.simplilearn.webapp.DB.DataBaseConnection;

@WebServlet("/list-product")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DataBaseConnection db = null;
		
		try {
			// step 1: create connection
			db = new DataBaseConnection();
			db.init();
			
			// step 2: create statement and execute query 
			String query = "SELECT * from eproducts";
			ResultSet rst = db.executeQuery(query);
			
			request.getRequestDispatcher("index.jsp").include(request, response);
			
			out.print("<div style='text-align:center;border:2px solid green; padding:20px;'>");
			while (rst.next()) {
				out.print("<div style=text-align:center;border:2px solid black; padding:5px; margin: auto 20%>");
				out.print("<p>" + rst.getInt("product_id") + "  ,  "+ rst.getString("product_name") + 
						"  ,  " + rst.getString("product_desc") +"  ,  "+rst.getDouble("price"));
				out.print("</div>");
			}
			out.print("</div>");
		} catch (Exception e) {
			 e.printStackTrace();
			out.println("<h2> Exception Occured </h2>");
		} finally {
			out.close();
			db.close();
		}
	}

}
