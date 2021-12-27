package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.model.UserDetails;

public class UserDetailsDao {
	public void insertUser(UserDetails user) {
		String insertQuery = "insert into USER_DETAILS(USER_NAME,EMAIL,USER_PASSWORD,MOBILE_NUMBER) VALUES (?,?,?,?)";

		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, user.getUser_name());
			pst.setString(2, user.getEmailId());
			pst.setString(3, user.getUser_password());
			pst.setLong(4, user.getMobile_Number());
			 
			pst.executeUpdate();
			System.out.println("Value Inserted Successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted");

		}
	}

	public UserDetails validateUser(String emailId, String password) {
		String ValidateQuery = "select * from USER_DETAILS where role='USER' and email='" + emailId + "' and user_password='"
				+ password + "'";
		Connection con = ConnectionUtil.getDbConnection();
		UserDetails user = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(ValidateQuery);
			if (rs.next()) {
				user = new UserDetails(rs.getInt(1), rs.getString(2), emailId, password, rs.getLong(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement Error");
		}
		return user;
	}

	public  void updateUser(String name,String password,String email) {

		String updatequery1 = "update user_details set user_name=?,user_password=? where email=?";
		Connection con = ConnectionUtil.getDbConnection();

		try {
			PreparedStatement pstmt = con.prepareStatement(updatequery1);
			pstmt.setString(1,name);
			pstmt.setString(2,password);
			pstmt.setString(3,email);
			int i = pstmt.executeUpdate();
			System.out.println(i + " user profile updated");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("values not updated");
			System.out.println("something went wrong");
		}
		 
	}

	public UserDetails admin(String email_id, String password) {
		String AdminQuery = "select * from user_details where role='ADMIN' and email='" + email_id + "'and user_password='"
				+ password + "'";

		Connection con = ConnectionUtil.getDbConnection();
		UserDetails user1 = null;
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(AdminQuery);
			if (rs.next()) {
				user1 = new UserDetails(rs.getInt(1), rs.getString(2), email_id, password, rs.getLong(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user1;
	}
	public List<UserDetails> viewUser(){
		List<UserDetails> userList=new ArrayList<UserDetails>();
		String view="select * from User_details where role='USER'";
		Connection con=ConnectionUtil.getDbConnection();
		 try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(view);
			while(rs.next()) {
				UserDetails user=new UserDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5) );
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}
	public void deleteDetails(String email) {
		String deleteQuery="delete from user_details where email=?";
		Connection con=ConnectionUtil.getDbConnection();
		 try {
			PreparedStatement pst= con.prepareStatement(deleteQuery);
			pst.setString(1, email);
			int i=pst.executeUpdate();
			System.out.println(i+"row deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		 
	}

