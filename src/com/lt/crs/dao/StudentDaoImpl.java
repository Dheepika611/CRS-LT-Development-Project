package com.lt.crs.dao;

import java.sql.SQLException;

import com.lt.crs.constants.SqlConstant;
import com.lt.crs.utils.DBUtils;

public class StudentDaoImpl extends DBUtils implements StudentDaoInterface {
	java.sql.PreparedStatement ps = null;
	
  public void studentRegistration() throws SQLException{
	  java.sql.Connection con = DBUtils.getConnection();
	  
	  //String sql="insert into student values(?,?,?,?,?,?,?,?)";  //studid, studname, username, pwd, prim1, prim2, sec1, sec2
      ps = con.prepareStatement(SqlConstant.ADD_STUDENT);
   
      // Hard coded data 
      int id=1;
      String name="Stud1";
      String username="root";
      String pwd="root";
      int prim1=101;
      int prim2=102;
      int sec1=103;
      int sec2=104;
      
      ps.setInt(1, id);  
      ps.setString(2,name);
      ps.setString(3, username);
      ps.setString(4, pwd);
      ps.setInt(5, prim1);
      ps.setInt(6, prim2);
      ps.setInt(7, sec1);
      ps.setInt(8, sec2);
      
      ps.executeUpdate();

      System.out.println("******Student Added to CRS DB******");
      ps.close();
      //con.close();
  }
}
