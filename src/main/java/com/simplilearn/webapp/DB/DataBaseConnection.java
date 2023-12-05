package com.simplilearn.webapp.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	private final String DB_URL="jdbc:mysql://localhost:3306/estore_zone-db";
	Connection con=null;
	Statement statement=null;
	ResultSet rst=null;
	public Connection init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Register Driver class ");
			con=DriverManager.getConnection(DB_URL, "root", "Root@999");
			System.out.println("2.Connection was establsihed");
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("Exception occured: "+e.getClass());
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Exception occured: "+e.getClass());
			e.printStackTrace();
		}
		return con;
	}
	public void close() {
		try {
			con.close();
			System.out.println("5.Connection was closed.");
		}catch(SQLException e) {
			System.out.println("Exception occured: "+e.getClass());
		}
	}
	
	public ResultSet executeQuery(String query){
		try {
			statement=con.createStatement();
			System.out.println("3.Statement is created");
			rst=statement.executeQuery(query);
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Exception occured: "+e.getClass());
			
		}
		
		
			return rst;
		
	}
	public int executeUpdate(String query) throws SQLException {
		int rowsAffected=0;
		try {
			if(statement==null)
			statement=con.createStatement();
			System.out.println("3.statement is created.");
			rowsAffected=statement.executeUpdate(query);
			System.out.println("4.Query is executyed");
			
			
		}catch(SQLException e) {
			
			System.out.println("Exception occured: "+e.getClass());
			
		}
		System.out.println(rowsAffected);
	
		return rowsAffected;
	}
		
		public void jdbcOperation(){
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Register Driver class");
			con=DriverManager.getConnection(DB_URL,"root","Root@999");
			System.out.println("2.Connection is created");
			statement=con.createStatement();
			System.out.println("3.Statement is created"+statement );
			String query="SELECT * FROM eproducts";
			rst=statement.executeQuery(query);
			System.out.println("4.Query is executed");
		}catch(ClassNotFoundException e) {
			
			System.out.println("Exception occured: "+e.getClass());
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Exception occured: "+e.getClass());
			e.printStackTrace();
		}
			finally {
				try {
					statement.close();
					con.close();
					rst.close();
					System.out.println("5.connection is closed");
					}catch(SQLException e) {
						System.out.println("Exception occured: "+e.getClass());
					}
			}
			
			
		}
	}
	

