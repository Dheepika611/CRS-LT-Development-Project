package com.lt.crs.business;

import java.sql.SQLException;

import com.lt.crs.app.CRSStudentMenu;
import com.lt.crs.bean.ReportCard;
import com.lt.crs.dao.ReportCardDaoImpl;
/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class contains the user inputs for ReportCard Module
 */
public class ReportCardOperations implements ReportCardInterface {
	ReportCardDaoImpl reportImpl = new ReportCardDaoImpl();
public void displayResult(String username){
	System.out.println(String.format("%S", "-------------Report Details--------------\n"));
    System.out.println("*********************************************************");
    System.out.println("|stud_id |\t stud_name |\t Course id|\t Marks|\t status|");
    System.out.println("***********************************************************");
    reportImpl.Reportcardbystudentid(username);
       try {
		CRSStudentMenu.studentLogin(username);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
