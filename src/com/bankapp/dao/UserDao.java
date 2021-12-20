package com.bankapp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankapp.model.User;

public class UserDao {
	public void insertUser(User user) {
		String insertQuery="insert into USER_DETAILS(NAME,EMAIL,PASSWORD,MOBILE_NUMBER) VALUES (?,?,?,?)";
		
		ConnectionUtil conUtil=new ConnectionUtil();
		Connection con=conUtil.getDbConnection();
		PreparedStatement pst=null;
		 
			try {
				pst=con.prepareStatement(insertQuery);
				pst.setString(1,user.getName());
				pst.setString(2,user.getEmailId());
				pst.setString(3,user.getPassword());
				pst.setLong(4,user.getMobileNumber());
				pst.executeUpdate();
				System.out.println("Value Inserted Successfully");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Value not inserted");
				
			}
	}
		public  User validateUser(String emailId,String password)
		{
			String ValidateQuery="select  * from USER_DETAILS where EMAIL='"+emailId+"' and PASSWORD='"+password+"'";
			Connection con=ConnectionUtil.getDbConnection();
			User user=null;
			 try {
				 Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(ValidateQuery);
					if(rs.next())
					{
						user=new User(rs.getString(2),emailId,password,rs.getLong(5));
					}
					else {
						System.out.println("Not a valid user");
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Statement Error");
			}
			return user;
		}
			
		
		public void updateUser(User user)
		{
			String updatequery="UPDATE USER_DETAIL SET PASSWORD=? WHERE  NAME=?";
			String updatequery1="update user_details set name=?,password=? where email=?";
			Connection con=ConnectionUtil.getDbConnection();
			PreparedStatement pstmt=null;
			try
			{
				pstmt=con.prepareStatement(updatequery);
				pstmt.setString(4, user.getPassword());
				pstmt.executeUpdate();
				System.out.println("value update successfully");
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getName());
				int i=pstmt.executeUpdate();
				System.out.println(i+" user profile updated");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("values not updated");
				System.out.println("something went wrong");
			}
		}
}
	
