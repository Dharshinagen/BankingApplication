package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.model.Loans;
import com.bankapp.model.UserDetails;

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
	public List<Loans> viewloan(){
		List<Loans> userList=new ArrayList<Loans>();
		String view1="select LOAN_NUMBER from loans  where  LOAN_status='not approved'";
		Connection con1=ConnectionUtil.getDbConnection();
		 try {
			Statement st=con1.createStatement();
			ResultSet rs=st.executeQuery(view1);
			while(rs.next()) {
				Loans user=new Loans(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getString(8)) ;
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}

}
