package com.lt.crs.business;

import com.lt.crs.bean.ReportCard;

public class ReportCardOperations implements ReportCardInterface {
	ReportCard rc[] = new ReportCard[1];
public void displayResult(){
	rc[0] = new ReportCard();
	rc[0].setGrade('A');
	rc[0].setPercent(88);
	rc[0].setResult("PASS");
	for(ReportCard r : rc){		
   		System.out.println("Grade: "+r.getGrade() + " ,Percent: " +r.getPercent()+ " ,Result: " +r.getResult());
	}
}
}
