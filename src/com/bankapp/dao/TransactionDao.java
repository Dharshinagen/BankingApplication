package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDao {

	public void depositAmount(long sender_AccNO,double amount,int pin_No,long receiver_AccNO) {
		 Connection con=ConnectionUtil.getDbConnection();
		 String query="update  account_details SET  Balance= '"+amount+"' + (select balance from account_details where Account_number='"+ receiver_AccNO+"' )  where ACCOUNT_NUMBER='"+ receiver_AccNO+"'";
		//  Statement pst =  ;
		 
	}
	public void withdrawAmount(long accountNo,double w_amount,int pinNo) {
		Connection con=ConnectionUtil.getDbConnection();
	}
	public void viewBalance(long account_number,int pinNo)
	{
		Connection con=ConnectionUtil.getDbConnection();
		String query1="select BALANCE from Transaction where Account_number=? and Pin_number=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(query1);
			pst.setLong(1,account_number);
			pst.setInt(2, pinNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
