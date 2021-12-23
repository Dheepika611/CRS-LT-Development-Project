package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lt.crs.constants.SqlConstant;
import com.lt.crs.utils.DBUtils;
/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class connects to the DB and implements all ReportCard related operations
 */
public class ReportCardDaoImpl implements ReportCardDaoInterface {
    static Connection con = DBUtils.getConnection();
    public void Reportcardbystudentid( String username){
        PreparedStatement ps1 = null;
		try {
			ps1 = con.prepareStatement(SqlConstant.FETCH_USER_ID);
			 ps1.setString(1, username);
		        ResultSet rs1 = ps1.executeQuery();
		        int userId =0;
		        while(rs1.next()){
		            userId=rs1.getInt("user_id");
		        }
		        PreparedStatement ps2 = con.prepareStatement(SqlConstant.REPORT_BY_STUDENT_ID);
		        ps2.setInt(1,userId);
		        ResultSet rs=ps2.executeQuery();
		        while(rs.next()){
		            System.out.println(rs.getInt("user_id")+"\t   "+rs.getString("username")+"\t\t"+rs.getInt("course_id")+"\t\t"+rs.getInt("marks")+"\t\t"+rs.getString("status"));
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
