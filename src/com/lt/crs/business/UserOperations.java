package com.lt.crs.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lt.crs.bean.User;
import com.lt.crs.dao.UserDaoImpl;
/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class fetches the user inputs for User details
 */
public class UserOperations implements UserInterface{
static Scanner sc = new Scanner(System.in);
static List passwordInput = new ArrayList();
UserDaoImpl userImpl = new UserDaoImpl();

public void loginDetails(){
	Scanner s = new Scanner(System.in);
	System.out.println("Enter your username: ");
	String username = s.next();
	System.out.println("Enter your password: ");
	String pass = s.next();
	userImpl.checkUser(username, pass);
} 

	public List getPasswordDetailsFromUser() {
		// TODO Auto-generated method stub
		System.out.println("Enter 1.Admin, 2.Student, 3.Professor: ");
		passwordInput.add(sc.next());
		System.out.println("Enter username: ");
		passwordInput.add(sc.next());
		System.out.println("Enter old password: ");
		passwordInput.add(sc.next());
		System.out.println("Enter new password: ");
		passwordInput.add(sc.next());
		return passwordInput;
	}

}
