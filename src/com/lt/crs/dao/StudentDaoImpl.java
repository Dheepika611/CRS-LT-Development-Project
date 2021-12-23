package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lt.crs.app.CRSApplication;
import com.lt.crs.constants.SqlConstant;
import com.lt.crs.utils.DBUtils;
/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class connects to the DB and implements all Student related operations
 */
public class StudentDaoImpl extends DBUtils implements StudentDaoInterface {
	static PreparedStatement ps = null;
	static Connection con = DBUtils.getConnection();

public void addUserByStudent(List studInp){
	  PreparedStatement ps2;
	try {
		ps2 = con.prepareStatement(SqlConstant.SELECT_MAX_USER_ID);
		ResultSet rs = ps2.executeQuery();
		  int max=0;
		  while(rs.next()){
			  max=rs.getInt("user_id");
		  }
	      
	      ps = con.prepareStatement(SqlConstant.ADD_USER_BY_STUDENT);
	      int userId = ++max;
	      ps.setInt(1, userId);
	      ps.setString(2, (String)studInp.get(3)); //username
	      ps.setString(3, (String)studInp.get(4)); //password
	      ps.executeUpdate();
	      ps.close();
	      studentRegistration(studInp, userId);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
@Override
public void studentRegistration(List studInp,int userId){
	  PreparedStatement ps1;
	try {
		ps1 = con.prepareStatement(SqlConstant.SELECT_MAX_STUD_ID);
		ResultSet rs = ps1.executeQuery();
		  int max=0;
		  while(rs.next()){
			  max=rs.getInt("stud_id");
		  }
	    
	    ps = con.prepareStatement(SqlConstant.SELF_REGISTER);
	    ps.setInt(1, ++max);
	    ps.setString(2, (String)studInp.get(0)); //name
	    ps.setString(3, (String)studInp.get(1)); //email
	    ps.setString(4, (String)studInp.get(2)); //dob
	    ps.setInt(5, userId);
	    ps.executeUpdate();
	    System.out.println("******Student Added to CRS DB******");
	    ps.close();
	    CRSApplication.mainMenu();
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
}
