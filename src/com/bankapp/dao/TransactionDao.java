package com.bankapp.dao;

 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankapp.model.AccountDetails;
import com.bankapp.model.UserDetails;

public class TransactionDao {
	
	
	public AccountDetails validatePinNumber(String Account_number,String pinnumber) {
	String ValidateQuery = "select * from  where account_number= "+ Account_number + "' and pin_number='"+pinnumber+"'";
	Connection con = ConnectionUtil.getDbConnection();
	AccountDetails user = null;
	try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(ValidateQuery);
		if (rs.next()) {
			user = new AccountDetails(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7) ,rs.getLong(8),
					rs.getString(9), rs.getString(10),rs.getString(11),rs.getInt(12),rs.getInt(13) );
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Statement Error");
	}
	return user;
}


	public void depositAmount(long sender_AccNO, String Name, double amount, int pin_No, long receiver_AccNO) {
		Connection con = ConnectionUtil.getDbConnection();
		String rec_query = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = ? +(select balance from account_details where account_number=?) WHERE  ACCOUNT_NUMBER= ?  ";
		String rec_query1 = "select balance from account_details where account_number=?";
		double balance = 0;
		String rec_query2 = "insert into transaction (sender_account_number,name,transaction_type,receiver_account_number,amount,balance,transaction_status)values(?,?,'DEPOSIT AMOUNT',?,?,?,'CREDITED')";

		String send_query = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = (select balance from account_details where account_number=?)-? WHERE  ACCOUNT_NUMBER= ? AND PIN_NUMBER= ? ";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(rec_query);

			ps.setDouble(1, amount);
			ps.setLong(2, receiver_AccNO);
			ps.setLong(3, receiver_AccNO);
			ps.executeUpdate();

			ps = con.prepareStatement(rec_query1);
			ps.setDouble(1, receiver_AccNO);
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble("balance");
			}

			ps = con.prepareStatement(rec_query2);
			ps.setLong(1, sender_AccNO);
			ps.setString(2, Name);
			ps.setLong(3, receiver_AccNO);
			ps.setDouble(4, amount);
			ps.setDouble(5, balance);
			ps.executeUpdate();
			ps = con.prepareStatement(send_query);

			ps.setLong(1, sender_AccNO);
			ps.setDouble(2, amount);
			ps.setLong(3, sender_AccNO);
			ps.setInt(4, pin_No);

			ps.executeUpdate();
			System.out.println("AMOUNT TRANSFERED");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void withdrawAmount(String name,long accountNo, double w_amount, int pinNo) {
		Connection con = ConnectionUtil.getDbConnection();
		String sql0 = "select balance from account_details where account_number=?";

		PreparedStatement pst;
		double balance = 0;
		try {
			pst = con.prepareStatement(sql0);
			pst.setLong(1, accountNo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble("balance");
			}
			if (balance > w_amount) {
				double newbal = balance - w_amount;
				String sql = " UPDATE  ACCOUNT_DETAILS  SET BALANCE = ? WHERE  ACCOUNT_NUMBER= ? AND PIN_NUMBER= ? ";
				String sql1 = "insert into transaction (sender_account_number,name,transaction_type,receiver_account_number,amount,balance,transaction_status)values(?,?,'WITHDRAW',?,?,?,'DEBITED')";
				pst = con.prepareStatement(sql);

				pst.setDouble(1, newbal);
				pst.setLong(2, accountNo);
				pst.setInt(3, pinNo);
				pst.executeUpdate();
				System.out.println("Amount debited from your account");
				pst = con.prepareStatement(sql1);
				pst.setLong(1, accountNo);
				pst.setString(2,name);
				pst.setLong(3, accountNo);
				pst.setDouble(4, w_amount);
				pst.setDouble(5, newbal);
				pst.executeUpdate();
			} else {
				System.out.println("Amount Insuffciant");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double viewBalance(long account_number, int pinNo) {
		Connection con = ConnectionUtil.getDbConnection();
		String query1 = "select BALANCE from account_details where Account_number=? and Pin_number=?";
		PreparedStatement pst;
		double balance = 0;
		try {

			pst = con.prepareStatement(query1);
			pst.setLong(1, account_number);
			pst.setInt(2, pinNo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				balance = rs.getDouble("balance");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balance;
	}
	public  long  getPinnumber( long accountno)
	{
		String query = "select pin_number from Account_Details where account_number = ?";
		Connection con=ConnectionUtil.getDbConnection();
		try {
			PreparedStatement pst= con.prepareStatement(query);
			pst.setLong(1, accountno  );
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				return rs.getLong("user_id");
			}else {
				return 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
