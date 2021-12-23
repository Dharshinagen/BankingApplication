package com.bankapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DepositsDao {
 public   double getInterest(double descriptionId) {
	 String updatequery1 = "select INTEREST_RATE from ADMIN_USE where DESCRIPTION_ID=?";
	Connection con = ConnectionUtil.getDbConnection();
	ResultSet rs = null;

	try {
		PreparedStatement pstmt = con.prepareStatement(updatequery1);
		 
		pstmt.setDouble(1,descriptionId);
		rs = pstmt.executeQuery();
		if(rs.next())
			return rs.getDouble("INTEREST_RATE");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
 }
 public void fixedDeposit(String type,double amount,double rate_of_interest,double maturity_value,long period,String status, long userId) {
	 Connection con = ConnectionUtil.getDbConnection();
	 String que="select deposit_acc.nextval from dual";
	 String Query="INSERT INTO DEPOSITS (USER_ID,ACCOUNT_NUMBER,DEPOSIT_TYPE,AMOUNT,TENURE,RATE_OF_INTEREST,MATURITY_DATE,MATURITY_VALUE,DEPOSIT_STATUS) VALUES(?,?,?,?,?,?,?,?,?)";
	 LocalDate sysDate=LocalDate.now();
     Date mdate = Date.valueOf( sysDate.plusYears(period));
	long accNumber = 0;
	 try {
		 
		PreparedStatement pstmt = con.prepareStatement(que);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
			accNumber = rs.getLong(1);
		pstmt = con.prepareStatement(Query);
		pstmt.setLong(1, userId);
		pstmt.setLong(2, accNumber);
		pstmt.setString(3,type);
		pstmt.setDouble(4,amount);
		pstmt.setDouble(5,period);
		pstmt.setDouble(6,rate_of_interest);
		pstmt.setDate(7, mdate);
		pstmt.setDouble(8,maturity_value);
		pstmt.setString(9, status);
		pstmt.executeUpdate();
		System.out.println( "Requested");
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
	 public void recurringDeposit(String type, long amount, long period,double rate_of_interest,double maturity_value,String status, long userId) {
		 Connection con = ConnectionUtil.getDbConnection();
		 String que="select deposit_acc.nextval from dual";
		 String Query="INSERT INTO DEPOSITS (USER_ID,ACCOUNT_NUMBER,DEPOSIT_TYPE,AMOUNT,TENURE,RATE_OF_INTEREST,MATURITY_DATE,MATURITY_VALUE,DEPOSIT_STATUS) VALUES(?,?,?,?,?,?,?,?,?)";
		  
		 LocalDate sysDate=LocalDate.now();
	     Date mdate = Date.valueOf( sysDate.plusYears(period));
	     long accNumber = 0;
		
		 try {
			 PreparedStatement pstmt = con.prepareStatement(que);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
					accNumber = rs.getLong(1);
			 pstmt = con.prepareStatement(Query);		  
			 pstmt.setLong(1, userId);
				pstmt.setLong(2, accNumber);
				pstmt.setString(3,type);
				pstmt.setDouble(4,amount);
				pstmt.setDouble(5,period);
				pstmt.setDouble(6,rate_of_interest);
				pstmt.setDate(7, mdate);
				pstmt.setDouble(8,maturity_value);
				pstmt.setString(9, status);
			pstmt.executeUpdate();
			System.out.println("Requested");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
 public void updateStatusAdmin() {
	 
 }
}
