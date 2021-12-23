package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 public void fixedDeposit(String type,double amount,double rate_of_interest,double maturity_value,double period,String status) {
	 Connection con = ConnectionUtil.getDbConnection();
	 String Query="INSERT INTO DEPOSITS (DEPOSIT_TYPE,AMOUNT,TENURE,RATE_OF_INTEREST,MATURITY_DATE,MATURITY_VALUE,DEPOSIT_STATUS) VALUES(?,?,?,?,?,?,?)";
	  
	String date="select extract(YEAR FROM Sysdate) from  dual";
  System.out.println(date);
	 ResultSet rs=null;
	 int maturity_date=0;
	
	 try {
		PreparedStatement pstmt = con.prepareStatement(date);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.println(rs.getString(1));
			  maturity_date= (int)(period) +(Integer.parseInt(rs.getString(1))) ;
			  System.out.println(maturity_date);
		}
		//pstmt.setLong(1,acc_number);
		pstmt.setString(1,type);
		pstmt.setDouble(2,amount);
		pstmt.setDouble(3,period);
		pstmt.setDouble(4,rate_of_interest);
		pstmt.setInt(5,maturity_date);
		pstmt.setDouble(6,maturity_value);
		pstmt.setString(7, status);
		int i=pstmt.executeUpdate();
		System.out.println(i+"Inserted");
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
	 public void recurringDeposit(long acc_number,double amount,double rate_of_interest,double maturity_value,double period) {
		 Connection con = ConnectionUtil.getDbConnection();
		 String Query="INSERT INTO DEPOSITS (DEPOSIT_TYPE,AMOUNT,TENURE,RATE_OF_INTEREST,MATURITY_DATE,MATURITY_VALUE,DEPOSIT_STATUS) VALUES('RECURRINGDEPOSIST',?,?,?,?,?,'NOT DEPOSITED')";
		  
		 String date="select extract(YEAR FROM DATE_OF_DEPOSIT) from deposits";
		 ResultSet rs=null;
		 String maturity_date=null;
		
		 try {
			PreparedStatement pstmt = con.prepareStatement(date);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				  maturity_date= period + rs.getString( date);
			}
			//pstmt.setLong(1,acc_number);
			pstmt.setDouble(1,amount);
			pstmt.setDouble(2,period);
			pstmt.setDouble(3, rate_of_interest);
			pstmt.setString(4,maturity_date);
			pstmt.setDouble(5,maturity_value);
			pstmt.executeQuery();
			System.out.println("Inserted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
 public void updateStatusAdmin() {
	 
 }
}
