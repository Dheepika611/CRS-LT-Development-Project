package com.lt.crs.dao;

import java.sql.SQLException;
import java.util.List;

public interface StudentDaoInterface {
	public void addUserByStudent(List studInp);
	public void studentRegistration(List studInp,int userId);
}
