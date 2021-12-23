package com.lt.crs.business;

import java.sql.SQLException;
import java.util.Scanner;

import com.lt.crs.app.CRSApplication;
import com.lt.crs.app.CRSStudentMenu;
import com.lt.crs.bean.Course;
import com.lt.crs.dao.CourseDaoImpl;
/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class contains the user inputs for Course
 */
public class CourseOperations implements CourseInterface{
	Scanner s = new Scanner(System.in);
	CourseDaoImpl courseImpl = new CourseDaoImpl();
	public void displayCourse(String username) {
		//System.out.println("--------- LIST OF COURSES AVAILABLE ----------\nID \t|"+" Course \t|"+ " Sem \t|"+ " PreReq ");
		 System.out.println(String.format("%S", "-------------Course Details--------------\n"));
		 System.out.println("********************************************");
		 System.out.println("|ID |\t Course Fee |\t Course Name|");
		 System.out.println("********************************************");
		 courseImpl.getCourse(username);
		 addCourse(username);
	}
	
	
	/** 
	 * This method will add course to the student @param username
	 */
		public void addCourse(String username){
		System.out.println("\nEnter the COURSEID to add course:");
		int courseinp = s.nextInt();
		courseImpl.addCourseToStudent(courseinp, username);
		
		System.out.println("Do you wish to add another course? \t [Y/N] ");
		String c = s.next();
		if(c.equals("Y"))
			displayCourse(username);
		else
			try {
				CRSStudentMenu.studentLogin(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		/** 
		 * This method will add course to the student @param username
		 */	
	public void dropCourseFromStudent(String username) {
		// TODO Auto-generated method stub
		//displayCourse(username);   --- THIS WILL SHOW ALL THE COURSE
		courseImpl.getCourseForStudent(username);
		System.out.println("Enter the COURSEID to drop: ");
		int dropInp = s.nextInt();
		courseImpl.dropCourseFromStudent(dropInp, username);
	}
}
