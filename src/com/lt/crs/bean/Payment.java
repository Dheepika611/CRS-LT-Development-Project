package com.lt.crs.bean;

/**
 * 
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This Class is the bean class for Payment
 *
 */
public class Payment {
	
private boolean paymentStatus;
private int billNo;
private String billMode;

public boolean isPaymentStatus() {
	return paymentStatus;
}
public void setPaymentStatus(boolean paymentStatus) {
	this.paymentStatus = paymentStatus;
}
public int getBillNo() {
	return billNo;
}
public void setBillNo(int billNo) {
	this.billNo = billNo;
}
public String getBillMode() {
	return billMode;
}
public void setBillMode(String billMode) {
	this.billMode = billMode;
}
}
