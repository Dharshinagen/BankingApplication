package com.bankapp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankapp.model.AccountDetails;

public class TransactionDao {

	public void depositAmount(long sender_AccNO,double amount,int pin_No,long receiver_AccNO) {
		 Connection con=ConnectionUtil.getDbConnection();
		 String rec_query = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = ? +(select balance from account_details where account_number=?) WHERE  ACCOUNT_NUMBER= ?  ";
		 String rec_query1="select balance from account_details where account_number=?";
		 double balance=0;
		 String rec_query2="insert into transaction (account_number,transaction_type,amount,balance,transaction_status)values(?,'deposit',?,?,'deposited')";
		 
		 String send_query=" UPDATE  ACCOUNT_DETAILS  SET BALANCE = (select balance from account_details where account_number=?)-? WHERE  ACCOUNT_NUMBER= ? AND PIN_NUMBER= ? ";
		 
		 
		  PreparedStatement ps;
		try {
			ps = con.prepareStatement(rec_query);
			
			ps.setDouble(1, amount);
			ps.setLong(2,receiver_AccNO);
			ps.setLong(3,receiver_AccNO );
		//  ps.setInt(4, pin_No);
		//	ps.setLong(5,receiver_AccNO);
			ps.executeUpdate();
			 System.out.println("deposit added");
			 
			 ps = con.prepareStatement(rec_query1);
             ps.setDouble(1,receiver_AccNO);
             ps.executeUpdate();
              ResultSet rs = ps.executeQuery();
  			if(rs.next())
  			{
  				balance = rs.getDouble("balance");
  			}
  			
			 ps = con.prepareStatement(rec_query2);
			 ps.setLong(1, receiver_AccNO);
			 ps.setDouble(2, amount);
			 ps.setDouble(3, balance);
			 ps.executeUpdate();
			 ps = con.prepareStatement(send_query);
				
				ps.setLong(1, sender_AccNO);
				ps.setDouble(2,amount);
				ps.setLong(3,sender_AccNO );
				ps.setInt(4, pin_No);
				  
				ps.executeUpdate();
			 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

			 

		 
	}
	public void withdrawAmount(long accountNo,double w_amount,int pinNo) {
		Connection con=ConnectionUtil.getDbConnection();
		String sql0 ="select balance from account_details where account_number=?";
		
		PreparedStatement cs;
		double balance = 0;
		try {
			cs = con.prepareStatement(sql0);
			cs.setLong(1, accountNo);
			ResultSet rs = cs.executeQuery();
			if(rs.next())
			{
				balance = rs.getDouble("balance");
			}
			if(balance > w_amount)
			{
				double newbal = balance - w_amount;
				String sql = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = ? WHERE  ACCOUNT_NUMBER= ? AND PIN_NUMBER= ? ";
				String sql1="insert into transaction (account_number,transaction_type,amount,balance,transaction_status)values(?,'Withdraw',?,?,'debited')";
			cs = con.prepareStatement(sql);
			
			cs.setDouble(1,newbal);
			cs.setLong(2,accountNo);
			cs.setInt(3, pinNo);
			cs.executeUpdate();
			System.out.println("Amount debited from your account");
			 cs = con.prepareStatement(sql1);
			 cs.setLong(1,accountNo);
			 cs.setDouble(2, w_amount);
			 cs.setDouble(3, newbal);
			 cs.executeUpdate();
			}
			else {
				System.out.println("Amount Insuffciant");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public double viewBalance(long account_number,int pinNo)
	{
		Connection con=ConnectionUtil.getDbConnection();
		String query1="select BALANCE from account_details where Account_number=? and Pin_number=?";
		PreparedStatement pst;
		double balance=0;
		try {
			
			pst = con.prepareStatement(query1);
			pst.setLong(1,account_number);
			pst.setInt(2, pinNo);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				  balance = rs.getDouble("balance");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balance;
	}
}
