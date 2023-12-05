package com.simplilearn.webapp.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.simplilearn.webapp.DB.DataBaseConnection;

@WebServlet("/delete-product")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("delete-product.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String productId = request.getParameter("product-id");
		
		DataBaseConnection db = null;
		
		try {
			
			db = new DataBaseConnection();
			db.init();
			
			
			String query = "DELETE from eproducts where product_id="+productId+";";
			int result = db.executeUpdate(query);
			
			request.getRequestDispatcher("index.jsp").include(request, response);
			
			if(result>0) {
				out.println("<h2> Product is delete sucessfully ! </h2>");
			} else {
				out.println("<h2> Product deletion is failed ! </h2>");
			}
			
		} catch (Exception e) {
			// e.printStackTrace();
			out.println("<h2> Exception Occured </h2>");
		} finally {
			out.close();
			db.close();
		}
	}

}
