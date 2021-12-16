package com.lt.crs.business;

import java.util.Scanner;

import com.lt.crs.app.CRSApplication;
import com.lt.crs.bean.Course;

public class CourseOperations extends StudentOperations implements CourseInterface{
	Course courses[] = new Course[3];
	Scanner s = new Scanner(System.in);
	public void addCourse(){
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Details..");
		
		for(int i=0; i<courses.length; i++)
		{
		System.out.println("Enter course ID: ");
		int id = sc.nextInt();
		System.out.println("Enter course name: ");
		String coursename = sc.next();
		
		courses[i] = new Course();
		courses[i].setCourseId(id);
		courses[i].setCourseName(coursename);
		}
		System.out.println("Successfully Added!"); */
		
		courses[0] = new Course();
		courses[0].setCourseId(101);
		courses[0].setCourseName("Java");
		courses[0].setSemester(1);
		courses[0].setPrereq("OOPS");
		
		courses[1] = new Course();
		courses[1].setCourseId(102);
		courses[1].setCourseName("Spring");
		courses[1].setSemester(2);
		courses[1].setPrereq("Java");
		
		courses[2] = new Course();
		courses[2].setCourseId(103);
		courses[2].setCourseName("Hibernate");
		courses[2].setSemester(3);
		courses[2].setPrereq("Java");
		
	}
	
	public void displayCourse(){
		addCourse();
		System.out.println("--------- LIST OF COURSES AVAILABLE ----------\nID \t|"+" Course \t|"+ " Sem \t|"+ " PreReq ");
		for(Course  c : courses){		
	   		System.out.println(c.getCourseId() + " \t| " +c.getCourseName()+ " \t| " +c.getSemester()+ " \t| "+ c.getPrereq());
		}
		System.out.println("\nEnter the COURSEID to add course:");
		int courseinp = s.nextInt();
		addCourseToStudent(courseinp);
		System.out.println("Do you wish to add another course? \t [Y/N] ");
		String c = s.next();
		if(c.equals("Y"))
			displayCourse();
		else
			CRSApplication.studentLogin();
	}
}
