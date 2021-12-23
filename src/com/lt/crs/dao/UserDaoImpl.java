package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.lt.crs.app.CRSApplication;
import com.lt.crs.constants.SqlConstant;
import com.lt.crs.utils.DBUtils;
import com.lt.crs.validation.LoginValidation;
/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class connects to the DB and implements all User related operations
 */
public class UserDaoImpl extends DBUtils implements UserDaoInterface {
	static Scanner sc = new Scanner(System.in);
	static Connection con = DBUtils.getConnection();
	
	//This method gets the data from user table and calls validateUser()
	public void checkUser(String username, String password){
		  PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(SqlConstant.VIEW_USERS);
			ps.setString(1, username);
			  ResultSet rs = ps.executeQuery();
			  if(rs.toString().equals(null))  //logic failing. Need to re-check on this
					System.out.println("Incorrect details. Please check!");
			  while(rs.next()){
				  String u=rs.getString(2);
				  String p=rs.getString(3);
				  int r=rs.getInt(4);
				  LoginValidation.validateUser(username, password, u, p,r);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  
	  }
	
	

	public void updatePassword(List inpList) {
		// TODO Auto-generated method stub
		try {
				PreparedStatement ps=con.prepareStatement(SqlConstant.UPDATE_PASSWORD);
				ps.setString(1, (String)inpList.get(3)); //new password
				ps.setString(2, (String)inpList.get(0)); //role
				ps.setString(3, (String)inpList.get(1)); //username
				ps.setString(4, (String)inpList.get(2)); //old password
				ps.executeUpdate();
				System.out.println("Password Updated Successfully!");
				CRSApplication.mainMenu();
			}catch(Exception e){
				System.out.println(e);
			}
	}
	
	public void checkPassword(String usernameinp, String oldpassinp, String newpassinp){
		PreparedStatement ps1 = null;
		try {
			ps1 = con.prepareStatement(SqlConstant.VIEW_USERS);
			ps1.setString(1, usernameinp);
			ResultSet rs = ps1.executeQuery();
			if(rs.toString().equals(null))  //logic failing. Need to re-check on this
				System.out.println("Incorrect details. Please check!");
			while(rs.next()){
				String udb=rs.getString(2);
				String pdb=rs.getString(3);
				int r=rs.getInt(4);
				LoginValidation.validatePassword(usernameinp, oldpassinp, newpassinp, udb, pdb,r);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  
	}
	}
