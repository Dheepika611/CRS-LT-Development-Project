package com.lt.crs.app;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.crs.business.PaymentOperations;
import com.lt.crs.business.CourseOperations;
import com.lt.crs.business.ReportCardOperations;
import com.lt.crs.business.StudentOperations;
import com.lt.crs.business.UserOperations;
import com.lt.crs.dao.UserDaoImpl;
import com.lt.crs.utils.DBUtils;
/**
 * 
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This Class is Main Application class
 *
 */
public class CRSApplication {
	private static Logger logger = Logger.getLogger(CRSApplication.class);
	CourseOperations co = new CourseOperations();
	PaymentOperations bo = new PaymentOperations();
	ReportCardOperations ro = new ReportCardOperations();

	DBUtils db = new DBUtils();
	static Scanner s = new Scanner(System.in);
	
	/*** Main Method calls only the mainMenu() ***/
	public static void main(String[] args) throws SQLException {
		System.out.println("************ WELCOME TO CRS APPLICATION ************");
		mainMenu();
	}
	
	/***mainMenu() will be divided based on the input from user***/
	public static void mainMenu() throws SQLException
	{
		logger.info("Inside mainMenu()");
		System.out.println("\n\t\t  MAIN MENU ");
		System.out.println("\t\t-------------");
		System.out.println("\n\t\t1.Login  \n\t\t2.Register Student  \n\t\t3.Update Password \n\t\t4.Exit ");
		System.out.println("----------------------------------------------------");
		int menu = s.nextInt();
		UserOperations uo = new UserOperations();
		StudentOperations so = new StudentOperations();
		UserDaoImpl userImpl = new UserDaoImpl();
		switch(menu){
		case 1:
			uo.loginDetails();
			break;
		case 2:
			so.registerStudent();
			break;
		case 3:
			userImpl.updatePassword(uo.getPasswordDetailsFromUser());
			break;
		case 4:
			System.out.println("Are you sure you want to Exit? Y/N");
			String ex = s.next();
			if(ex.equals("Y")) {
				System.out.println("Bye!");
				System.exit(0); 
				}
			else
				mainMenu();
			break;
		}
	}
			
}
