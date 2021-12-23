package com.lt.crs.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class connects to the DB using the values configured in config.properties
 */
public class DBUtils {
	public static Connection conn = null;
	
	/**
	* getConnection() method is defined here
	* Connection to the DB will be established here
	* @exception ClassNotFound(), FileNotFund(), IOException()
	*
	*/
	public static Connection getConnection() {
	 if (conn != null)
         return conn;
     else {
         try {
         	Properties prop = new Properties();
             InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
             prop.load(inputStream);
             String driver = prop.getProperty("driver");
             String url = prop.getProperty("url");
             String user = prop.getProperty("user");
             String password = prop.getProperty("password");
             Class.forName(driver);
             conn = DriverManager.getConnection(url, user, password);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             e.printStackTrace();
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return conn;
     }

 }

//This method is used for closing the DB connection
public void closeConnection() {
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	   }
