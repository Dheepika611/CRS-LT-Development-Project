package com.lt.crs.dao;

public interface PaymentDaoInterface {
	public void calculateBill(String username, int sem, int mode);
	public void insertIntoPayment(int studId, int mode, float billAmount);
	public void viewBill(String username, int sem);
}
