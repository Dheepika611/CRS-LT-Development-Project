package com.lt.crs.business;

import java.sql.SQLException;
import java.util.Scanner;

import com.lt.crs.app.CRSStudentMenu;
import com.lt.crs.dao.PaymentDaoImpl;
/**
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This class contains the user inputs for Payment module
 */
public class PaymentOperations extends CRSStudentMenu implements PaymentInterface{
	PaymentDaoImpl paymentImpl = new PaymentDaoImpl();
	Scanner sc = new Scanner(System.in);

	public int getSem(){
		System.out.println("Enter sem: ");
		int sem = sc.nextInt();
		return sem;
}
	public void makePayment(String username) {
		// TODO Auto-generated method stub
		int sem = getSem();
		System.out.println("Choose payment mode, \n1. Credit/Debit Card  \n2. UPI \n3. Cash at office");
		int mode = sc.nextInt();
		PaymentDaoImpl.calculateBill(username, sem, mode);
		try {
			studentLogin(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void viewPayment(String username){
		// TODO Auto-generated method stub
		int sem = getSem();
		paymentImpl.viewBill(username, sem);
	}
}
