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
		List<Loans> loans=new ArrayList<Loans>();
		String view1="select * from LOANS  where  LOAN_STATUS='Not Approved'";
		Connection con1=ConnectionUtil.getDbConnection();
		 try {
			Statement st=con1.createStatement();
			ResultSet rs=st.executeQuery(view1);
			while(rs.next()) {
				Loans loan=new Loans(rs.getInt(2),rs.getLong(3), rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getDouble(9),rs.getDouble(10),rs.getString(11));
				loans.add(loan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return loans;
	}
	public void updateStatus(long loan_number) {
		String que="UPDATE LOANS SET LOAN_STATUS='Approved' WHERE LOAN_NUMBER=?";
		Connection con=ConnectionUtil.getDbConnection();
		 try {
			PreparedStatement pst = con.prepareStatement(que);
			pst.setLong(1,loan_number);
			int i = pst.executeUpdate();
			System.out.println(i + " user profile updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
