package com.lt.crs.business;

import com.lt.crs.dao.ProfessorDaoImpl;
import com.lt.crs.dao.ProfessorDaoInterface;
/**
 * 
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This Class is realted Professor Operation
 *
 */
public class ProfessorOperations implements ProfessorInterface {

	ProfessorDaoInterface prd=null;
	
	public void viewStudent(int profId) {
		// TODO Auto-generated method stub
		prd=new ProfessorDaoImpl();
		try {
			prd.viewStudent(profId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public void addGrade(int profId) {
		// TODO Auto-generated method stub
		prd=new ProfessorDaoImpl();
		try {
			prd.addGrade(profId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}
		
	}
}