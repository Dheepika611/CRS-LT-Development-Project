package com.lt.crs.dao;

import java.sql.SQLException;

public interface CourseDaoInterface {
	public void getCourse(String username);
	public void addCourseToStudent(int courseinp, String username);
	
}
