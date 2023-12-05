package com.simplilearn.webapp.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.simplilearn.webapp.DB.DataBaseConnection;

@WebServlet("/update-product")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("update-product.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String productId=request.getParameter("product-id");
	    String productName=request.getParameter("product-name");
	    String productPrice=request.getParameter("product-price");
	    String productDesc=request.getParameter("product-desc");
	    DataBaseConnection db=null;
	    try {
	    	db=new DataBaseConnection();
	    	db.init();
	    	String query = "UPDATE eproducts SET product_name='" + productName + 
	                "', product_desc='" + productDesc + 
	                "', price='" + productPrice + 
	                "'  where product_id='" + productId + "';";

	    	int result=db.executeUpdate(query);
	    	request.getRequestDispatcher("index.jsp").include(request, response);
	    	if(result>0) {
	    		out.println("<h2>Product is Updated successfully </h2>");
	    	}else {
	    		out.println(result+"<h2>Product updation is failed</h2>");
	    	}
	    }catch(Exception e) {
	    	
	    	out.println("<h2>Exception occured</h2>");
	    	
	    }finally {
	    	db.close();
	    	out.close();
	    }

}
}
