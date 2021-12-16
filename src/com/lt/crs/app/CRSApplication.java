package com.lt.crs.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.lt.crs.business.PaymentOperations;
import com.lt.crs.business.CourseOperations;
import com.lt.crs.business.ReportCardOperations;
import com.lt.crs.dao.StudentDaoImpl;
import com.lt.crs.utils.DBUtils;

public class CRSApplication {
	static CourseOperations co = new CourseOperations();
	static PaymentOperations bo = new PaymentOperations();
	static ReportCardOperations ro = new ReportCardOperations();
	static DBUtils db = new DBUtils();
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("-----WELCOME TO CRS APPLICATION-----");
		mainMenu();
	}
	public static void mainMenu() throws SQLException
	{
		StudentDaoImpl sd = new StudentDaoImpl();
		System.out.println("\nMAIN MENU \n1.Login  \n2.Register Student  \n3.Update Password \n4.Exit ");
		int menu = s.nextInt();
		db.getConnection();
		switch(menu){
		case 1:
			loginMenu();
			break;
		case 2:
			sd.studentRegistration();
			registerMenu();
			break;
		case 3:
			break;
		case 4:
			break;
		}
		}
	
		private static List registerMenu() throws SQLException {
		// TODO Auto-generated method stub
			System.out.println("------- STUDENT REGISTRATION -------");
		System.out.println("Enter your name: ");
		List<String> l = new ArrayList<String>();
		l.add(s.next());
		System.out.println("Enter your ID: ");
		l.add(s.next());
		System.out.println("Enter your semester: ");
		l.add(s.next());
		System.out.println("Enter your password: ");
		l.add(s.next());
		System.out.println("Confirm your password: ");
		l.add(s.next());
		System.out.println("Successfully registered! ");
		System.out.println(l);
		System.out.println("-------------------------------------------");
		//daomethod();
		mainMenu();
		return l;
	}

		public static void loginMenu(){
		System.out.println(" ------ LOGIN AS ------- \n1. Student  2. Professor  \n3. Admin ");
		int inp = s.nextInt();	
		switch(inp){
		case 1:
			studentLogin();
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}
		
		public static void studentLogin(){
		String finaluser = "root";
		String finalpass = "root";
		Scanner s = new Scanner(System.in);
		//List inpList = new ArrayList();
		//inpList = registerMenu();
		//String finaluser = (String) inpList.get(1);
		//String finalpass = (String) inpList.get(1);
		
		System.out.println("Enter your username: ");
		String username = s.next();
		System.out.println("Enter your password: ");
		String pass = s.next();
		if(username.equals(finaluser) && pass.equals(finalpass)){

			System.out.println("\n \n------- STUDENT SCREEN -------\n Welcome " + username+ " student, Select one from the Menu below --");
			System.out.println("1. View and Register Course");
			System.out.println("2. Drop Course");
			System.out.println("3. Payment");
			System.out.println("4. View Grades");
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch(choice){
			case 1:
				co.displayCourse();
				break;
			case 2:
				System.out.println("You have selected drop course option. \nPlease enter the COURSE NAME to remove: ");
				String dropc = sc.next();
				co.dropCourseFromStudent(dropc);
				System.out.println("The course "+dropc+" has been removed for the student.");
				System.out.println("Do you wish to drop another course if Yes, give the course name? Name/N ");
				String c = s.next();
				if(!c.equals("N"))
					co.dropCourseFromStudent(c);
				else
					CRSApplication.studentLogin();
				break;
			case 3:
				System.out.println("Payment Status: Yes");
				bo.calculateBill();
				break;
			case 4:
				System.out.println("REPORT CARD");
				ro.displayResult();
				break;
			default:
				System.out.println("Select any one from 1-5");
			}
		}
		else
			System.out.println("Incorrect details! Try again.");
	}
}
