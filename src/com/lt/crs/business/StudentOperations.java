package com.lt.crs.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Student;
public class StudentOperations extends Course {
	Student students[] = new Student[2];
	String str = "";
	static List<String> studentCourses = new ArrayList<String>();
	public void addCourseToStudent(int courseinp){
		//String studentmap[] =  new String[2];
		
		switch(courseinp){
		case 101:
			studentCourses.add("Java");
			break;
		case 102:
			studentCourses.add("Spring");
			break;
		case 103:
			studentCourses.add("Hibernate");
		}
		System.out.println("Course Mapped!! ********************* "+studentCourses);
	}
	
	public void dropCourseFromStudent(String dropc){
		//System.out.println("Enter course name to drop from the student list: ");
		studentCourses.remove(dropc);
		System.out.println("Updated Course List for you: ********************* "+ studentCourses);
	}
}
