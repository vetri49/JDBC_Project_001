package com.simplilearn.webapp.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.simplilearn.webapp.DB.DataBaseConnection;

@WebServlet("/create-product")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("add-product.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    String productName=request.getParameter("product_name");
	    String productPrice=request.getParameter("product_price");
	    String productDesc=request.getParameter("product_desc");
	    DataBaseConnection db=null;
	    try {
	    	db=new DataBaseConnection();
	    	db.init();
	    	String query = "INSERT into eproducts(product_name, price,product_desc) values('" 
					+productName +"','" +productPrice +"' ,'"+productDesc+"')";
	    	int result=db.executeUpdate(query);
	    	request.getRequestDispatcher("index.jsp").include(request, response);
	    	if(result>0) {
	    		out.println("<h2>Product is created successfully </h2>");
	    	}else {
	    		out.println(result+"<h2>Product creation is failed</h2>");
	    	}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	out.println("<h2>Exception occured</h2>");
	    	
	    }finally {
	    	db.close();
	    	out.close();
	    }
		
	}

}
