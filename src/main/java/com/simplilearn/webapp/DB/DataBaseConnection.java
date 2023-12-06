package com.simplilearn.webapp.DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	private final String DB_URL="jdbc:mysql://localhost:3306/estore_zone-db";
	Connection con=null;
	Statement statement=null;
	ResultSet rst=null;
	PreparedStatement prepstm=null;
	CallableStatement callstm=null;
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
		public int executeUpdatePrepstmt(String query,String ... args) {
			int rowsAffected=0;
			try {
				prepstm=con.prepareStatement(query);
				System.out.println("3.Prepared statement is created.");
				prepstm.setString(1, args[0]);
				prepstm.setString(2, args[1]);
				prepstm.setString(3, args[2]);
				rowsAffected=prepstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Exception Occured ::: " + e.getClass());
				e.printStackTrace();
			} finally {
				// clean up
				try {
					prepstm.close();
				} catch (SQLException e) {
					System.out.println("Exception Occured ::: " + e.getClass());
				}

			}
			return rowsAffected;
		}
		public int executeUpdateCallStm(String query, String... args) {
			int rowsAffected = 0;
			try {
				// step3 : Create a callable statement
				callstm = con.prepareCall(query);
				System.out.println("3. Callable Statement is created.");
				
				// set parameters for prepare callstm
				// set product name
				callstm.setString(1, args[0]);
				// set product desc
				callstm.setString(2, args[1]);
				// set product price
				callstm.setString(3, args[2]);
				
				rowsAffected = callstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Exception Occured ::: " + e.getClass());
				e.printStackTrace();
			} finally {
				// clean up
				try {
					callstm.close();
				} catch (SQLException e) {
					System.out.println("Exception Occured ::: " + e.getClass());
				}

			}
			return rowsAffected;
		}
	}
	

