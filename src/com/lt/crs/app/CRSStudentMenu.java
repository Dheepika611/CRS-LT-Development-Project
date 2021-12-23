package com.lt.crs.app;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.crs.business.CourseOperations;
import com.lt.crs.business.PaymentOperations;
import com.lt.crs.business.ReportCardOperations;
/**
 * 
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This Class is for the Student Menu
 *
 */

public class CRSStudentMenu {
	private static Logger logger = Logger.getLogger(CRSStudentMenu.class);
//creating objects for other classes
static CourseOperations co = new CourseOperations();
static PaymentOperations po = new PaymentOperations();
static ReportCardOperations ro = new ReportCardOperations();

	//Student login method, allows the student to login CRS application
	public static void studentLogin(String username) throws SQLException{
		System.out.println("\n************** STUDENT SCREEN **************\n");
		System.out.println("\t1. View and Register Course");
		System.out.println("\t2. View and Drop Course");
		System.out.println("\t3. Payment Details");
		System.out.println("\t4. View Grades");
		System.out.println("\t5. Logout");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			co.displayCourse(username);
		break;
		case 2:
			co.dropCourseFromStudent(username);
			System.out.println("Do you wish to drop another course? Y/N ");
			String c = sc.next();
			if(!c.equals("N"))
				co.dropCourseFromStudent(username);
			else
				studentLogin(username);
		break;
		case 3:
			System.out.println("1.Make New Payment \n2.View Payment Details \n3.Go Back");
			int opt = sc.nextInt();
			switch(opt){
			case 1:
				po.makePayment(username); break;
			case 2:
				po.viewPayment(username); break;			
			case 3:
				studentLogin(username); break;
			}
			//po.calculateBill(username);
		break;
		case 4:
			System.out.println("REPORT CARD");
			ro.displayResult(username);
		break;
		case 5:
			CRSApplication.mainMenu(); break;
		default:
			System.out.println("Select any one from 1-5");
		}
	}
}
