package com.lt.crs.exceptions;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.lt.crs.utils.DBUtils;

public class UserIdAlreadyTakenException {
	static java.sql.Connection con = DBUtils.getConnection();
		 public static String regestationexception(String username) {
		String usernamedb=null;
		try {
		Scanner sc=new Scanner(System.in);
		Statement st=con.createStatement();
		String INSERT_MYSTUDENT_QUERY="select username FROM user where username= "+"\""+username+"\"";
		//process the query
		ResultSet rs=st.executeQuery(INSERT_MYSTUDENT_QUERY);
		//geting values
		rs.next();
		usernamedb=rs.getString(1);
		}catch(Exception e) {
		return null;
		}finally {
		}
		return usernamedb;
	}
}
	
