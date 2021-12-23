package com.lt.crs.validation;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.lt.crs.app.CRSAdminMenu;
import com.lt.crs.app.CRSApplication;
import com.lt.crs.app.CRSProfessorMenu;
import com.lt.crs.app.CRSStudentMenu;
import com.lt.crs.dao.UserDaoImpl;
// add @param comments
public class LoginValidation {
	
	//This method validates the username and pwd of user input and the data from database(user table)
	public static void validateUser(String userinp, String userpwd, String dbusername, String dbpass, int r) throws SQLException {
		if(userinp.equals(dbusername) && userpwd.equals(dbpass)){
	System.out.println("\n\nWELCOME "+dbusername+"\t\t\t TIME:"+LocalDateTime.now());
			switch(r){
			case 1:
				//CRSAdminMenu.adminMenu(dbusername); break;
			case 2:
				CRSStudentMenu.studentLogin(dbusername); break;
			case 3:
				//CRSProfessorMenu.profMenu(dbusername); break;
			}		
		}
		else
			System.out.println("INCORRECT LOGIN. Please check your username and password.");
	} //end of login(1) option

	public static void validatePassword(String usernameinp, String oldpassinp, String newpassinp, String udb,
			String pdb, int r) throws SQLException {
		// TODO Auto-generated method stub
		UserDaoImpl userImpl = new UserDaoImpl();
		List l = new ArrayList();
		l.add(r);
		l.add(udb);
		l.add(oldpassinp);
		l.add(newpassinp);
		if(oldpassinp.equals(pdb) && usernameinp.equals(udb)){
			userImpl.updatePassword(l);
		}
		else{
			System.out.println("Old password is incorrect. Please verify!");
			CRSApplication.mainMenu();
		}
	}

	
}
