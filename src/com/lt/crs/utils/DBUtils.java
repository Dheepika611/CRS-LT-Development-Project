package com.lt.crs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtils {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/crs";
	   
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	 // Connection class
	 public static Connection getConnection(){
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{			   
			   Class.forName("com.mysql.jdbc.Driver");
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      System.out.println("Creating statement...");
		   		}catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }
//			      try{
//			         if(conn!=null)
//			            conn.close();
//			      }catch(SQLException se){
//			         se.printStackTrace();
//			      }
			   }
			   System.out.println("Goodbye!");
			return conn;
			}
	   }
