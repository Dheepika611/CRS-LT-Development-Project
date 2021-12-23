package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lt.crs.constants.SqlConstant;
import com.lt.crs.utils.DBUtils;
/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class connects to the DB and implements all course related operations
 */
public class CourseDaoImpl implements CourseDaoInterface {
	static Connection con = DBUtils.getConnection();
	
	/**
	* getCourse() method is defined here
	* This method displays all the courses available from course_catalogue
	* @param VIEW_COURSE_CATALOGUE is an SQL Constant
	* @exception SQLException()
	*
	*/
	public void getCourse(String username) {
		// TODO Auto-generated method stub
		 PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(SqlConstant.VIEW_COURSE_CATALOGUE);
			ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 System.out.println("|"+rs.getInt("course_id")+" \t| "+ rs.getFloat("course_fee")+ " \t| "+rs.getString("course_name"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		 System.out.println("********************************************");
	}
	
	/**
	* addCourseToStudent() method is defined here
	* This method add the course selected by student to course table
	* @param FETCH_USER_ID is an SQL Constant
	* @param FETCH_STUDENT_ID is an SQL Constant
	* @exception SQLException()
	*
	*/
	public void addCourseToStudent(int courseinp, String username){
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		try {
			ps1 = con.prepareStatement(SqlConstant.FETCH_USER_ID);
			ps1.setString(1, username);
			ResultSet rs1 = ps1.executeQuery();
			int userId =0;
			while(rs1.next()){
				userId=rs1.getInt("user_id");
			}
			//System.out.println("UserID: "+userId);
			ps2 = con.prepareStatement(SqlConstant.FETCH_STUDENT_ID);
			ps2.setInt(1, userId);
			ResultSet rs2 = ps2.executeQuery();
			int studId =0;
			while(rs2.next()){
				studId=rs2.getInt("stud_id");
			}
			//System.out.println("StudID: "+studId);
			ps3 = con.prepareStatement(SqlConstant.ADD_COURSE_TO_STUDENT1);
			ps3.setInt(1, courseinp);
			ps3.setInt(2, studId);
			ps3.execute();
			System.out.println("Successfully Added to COURSE TABLE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ps1.close();
				ps2.close();
				ps3.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void dropCourseFromStudent(int courseinp, String username) {
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		try {
			ps1 = con.prepareStatement(SqlConstant.FETCH_USER_ID);
			ps1.setString(1, username);
			ResultSet rs1 = ps1.executeQuery();
			int userId =0;
			while(rs1.next()){
				userId=rs1.getInt("user_id");
			}
			//System.out.println("UserID: "+userId);
			ps2 = con.prepareStatement(SqlConstant.FETCH_STUDENT_ID);
			ps2.setInt(1, userId);
			ResultSet rs2 = ps2.executeQuery();
			int studId =0;
			while(rs2.next()){
				studId=rs2.getInt("stud_id");
			}
			//System.out.println("StudID: "+studId);
			ps3 = con.prepareStatement(SqlConstant.DROP_COURSE_FROM_STUDENT);
			ps3.setInt(1, courseinp);
			ps3.setInt(2, studId);
			ps3.execute();
			System.out.println("Successfully Removed from COURSE TABLE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ps1.close();
				ps2.close();
				ps3.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void getCourseForStudent(String username) {
		// TODO Auto-generated method stub
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		try {
			ps1 = con.prepareStatement(SqlConstant.FETCH_USER_ID);
			ps1.setString(1, username);
			ResultSet rs1 = ps1.executeQuery();
			int userId =0;
			while(rs1.next()){
				userId=rs1.getInt("user_id");
			}
			System.out.println("UserID: "+userId);
			ps2 = con.prepareStatement(SqlConstant.FETCH_STUDENT_ID);
			ps2.setInt(1, userId);
			ResultSet rs2 = ps2.executeQuery();
			int studId =0;
			while(rs2.next()){
				studId=rs2.getInt("stud_id");
			}
			System.out.println("StudID: "+studId);
			
			ps3 = con.prepareStatement(SqlConstant.SELECT_COURSE_FOR_STUDENT);
			//c.course_id, course_name, course_fee
			ps3.setInt(1, studId);
			ResultSet rs = ps3.executeQuery();
			while(rs.next()){
				System.out.println("|"+rs.getInt("course_id")+" \t| "+ rs.getFloat("course_fee")+ " \t| "+rs.getString("course_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ps1.close();
				ps2.close();
				ps3.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
