package com.lt.crs.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.crs.app.CRSApplication;
import com.lt.crs.dao.StudentDaoImpl;
import com.lt.crs.exceptions.UserIdAlreadyTakenException;

/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class fetches the user inputs for Student module
 */
public class StudentOperations implements StudentInterface {
	
	private static Logger logger = Logger.getLogger(StudentOperations.class);

	String str = "";
	static Scanner s= new Scanner(System.in);
	static List studentCourses = new ArrayList<String>();
	StudentDaoImpl studImpl = new StudentDaoImpl();
	
	/**
	* registerStudent() method is defined here
	* This method helps the student to self register
	* It gets the input from student and passes to the implementation class
	* @exception SQLException()
	*
	*/
	public void registerStudent() {
		String st;
		System.out.println("------- STUDENT REGISTRATION -------");
		List<String> l = new ArrayList<String>();
		System.out.println("Enter your Name: ");
		l.add(s.next());
		System.out.println("Enter your Email: ");
		l.add(s.next());
		System.out.println("Enter your DateOfBirth(YYYY-MM-DD): ");
		l.add(s.next());
		System.out.println("Create username: ");
		l.add(s.next());
		try {
		st=UserIdAlreadyTakenException.regestationexception(l.get(3));
		}catch(Exception e) {
		st=null;
		}
		if(l.get(3).equals(st)){
			final String ANSI_RED = "\033[0;31m";
			final String ANSI_RESET = "\033[0m";
		System.out.println("\t<WARNING> USER NAME ALREADY EXIST ");
		System.out.println("\tKindly try a different username.");
		registerStudent();
		}else {
		System.out.println("Create password: ");
		String pass1 = s.next();
		System.out.println("Confirm password: ");
		String pass2 = s.next();
		if(pass1.equals(pass2)){
		l.add(pass2);
		System.out.println("Successfully registered! ");
		studImpl.addUserByStudent(l);
		}
		else {
		System.out.println("Password does not match. Please verify.");
		}
		System.out.println(l);
		System.out.println("-------------------------------------------");
		}
	}
}
