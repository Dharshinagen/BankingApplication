package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoansDao {
	public    double getInterest(double descriptionId) {
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
	public void PersonalLoan( String type,double amount,double period,String type1,double interest_rate,double monthly_payments,int userid,String status) {
		String que="select Loan_acc.nextval from dual";
		String query="INSERT INTO LOANS (USER_ID,ACCOUNT_NUMBER,LOAN_TYPE,DESCRIPTION,LOAN_AMOUNT,TENURE,INTEREST_RATE,MONTHLY_PAYMENT,LOAN_STATUS)VALUES(?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionUtil.getDbConnection();
		 long accNumber = 0;
			
		 try {
			 PreparedStatement pstmt = con.prepareStatement(que);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
					accNumber = rs.getLong(1);
			 pstmt = con.prepareStatement(query);		  
			 pstmt.setInt(1, userid);
				pstmt.setLong(2, accNumber);
				pstmt.setString(3,type);
				pstmt.setString(4,type1);
				pstmt.setDouble(5 ,amount);
				pstmt.setDouble(6,period);
				pstmt.setDouble(7, interest_rate );
				pstmt.setDouble(8,monthly_payments);
				pstmt.setString(9, status);
			    pstmt.executeUpdate();
			System.out.println("Requested");
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void housingLoan( String type,double amount,double period,String type1,double interest_rate,double monthly_payments,int userid,String status) {
		String que="select Loan_acc.nextval from dual";
		String query="INSERT INTO LOANS (USER_ID,ACCOUNT_NUMBER,LOAN_TYPE,DESCRIPTION,LOAN_AMOUNT,TENURE,INTEREST_RATE,MONTHLY_PAYMENT,LOAN_STATUS)VALUES(?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionUtil.getDbConnection();
		 long accNumber = 0;
			
		 try {
			 PreparedStatement pstmt = con.prepareStatement(que);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
					accNumber = rs.getLong(1);
			 pstmt = con.prepareStatement(query);		  
			 pstmt.setInt(1, userid);
				pstmt.setLong(2, accNumber);
				pstmt.setString(3,type);
				pstmt.setString(4,type1);
				pstmt.setDouble(5 ,amount);
				pstmt.setDouble(6,period);
				pstmt.setDouble(7, interest_rate );
				pstmt.setDouble(8,monthly_payments);
				pstmt.setString(9, status);
			    pstmt.executeUpdate();
			System.out.println("Requested");
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
