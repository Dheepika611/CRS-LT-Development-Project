package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lt.crs.constants.SqlConstant;
import com.lt.crs.utils.DBUtils;
/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class connects to the DB and implements all payment related operations
 */
public class PaymentDaoImpl {
static Connection con = DBUtils.getConnection();

public static void calculateBill(String username, int sem, int mode){
	//System.out.println("inside getDetails()");
	  PreparedStatement ps1 =null;
	  PreparedStatement ps2 =null;
	  PreparedStatement ps3 =null;
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
		
		ps3 = con.prepareStatement(SqlConstant.FETCH_COURSE_FEE);
		ps3.setInt(1, studId);
		float courseFee = 0;
		ResultSet rs3 = ps3.executeQuery();
		while(rs3.next()){
		  //courseIds.add(rs3.getInt("course_id"));
			courseFee=rs3.getInt("sum(course_fee)");
	  } 
	  System.out.println("Total Bill Amount: "+courseFee);
	  insertIntoPayment(studId,mode,courseFee);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
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

private static void insertIntoPayment(int studId, int mode, float billAmount){
	// TODO Auto-generated method stub
	//bill_id, stud_id, mode_of_pay, bill_amount, bill_status
	PreparedStatement p;
	try {
		p = con.prepareStatement(SqlConstant.SELECT_MAX_BILL_ID);
		ResultSet r = p.executeQuery();
		int billId = 0;
		while(r.next()){
			billId = r.getInt("MAX(bill_id)");
		}
		PreparedStatement ps = con.prepareStatement(SqlConstant.INSERT_IN_PAYMENT);
		ps.setInt(1, ++billId);
		ps.setInt(2, studId);
		switch(mode){
		case 1:
			ps.setString(3, "Card"); break;
		case 2:
			ps.setString(3, "UPI"); break;
		case 3:
			ps.setString(3, "Cash"); break;
		}
		ps.setInt(4, (int) billAmount);
		ps.execute();
		System.out.println("Added to Payment table");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	public void viewBill(String username, int sem) {
		PreparedStatement ps1;
		try {
			ps1 = con.prepareStatement(SqlConstant.FETCH_USER_ID);
			ps1.setString(1, username);
			ResultSet rs1 = ps1.executeQuery();
			int userId =0;
			while(rs1.next()){
				userId=rs1.getInt("user_id");
			}
			System.out.println("UserID: "+userId);
			
			PreparedStatement ps2 = con.prepareStatement(SqlConstant.FETCH_STUDENT_ID);
			ps2.setInt(1, userId);
			ResultSet rs2 = ps2.executeQuery();
			int studId =0;
			while(rs2.next()){
				studId=rs2.getInt("stud_id");
			}
			System.out.println("StudID: "+studId);
			
			PreparedStatement ps3 = con.prepareStatement(SqlConstant.VIEW_BILL);
			ps3.setInt(1, studId);
			ResultSet rs3 = ps3.executeQuery();
			System.out.println("|ID|\tName|\tCourse|\tFee|");
			while(rs3.next()){
				System.out.println(rs3.getInt("stud_id")+"|\t"+rs3.getString("stud_name")+"|\t"+rs3.getString("course_name")+"|\t"+rs3.getInt("course_fee"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
