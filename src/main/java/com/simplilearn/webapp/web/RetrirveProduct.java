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
@WebServlet("/retrieve-product")
public class RetrirveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("retrieve-product.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String productId = request.getParameter("product-id");
		
		DataBaseConnection db = null;
		
		try {
			
			db = new DataBaseConnection();
			db.init();
			
			
			String query = "SELECT * from eproducts where product_id="+productId+";";
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


	


