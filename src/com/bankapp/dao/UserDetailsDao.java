package com.bankapp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankapp.model.UserDetails;

public class UserDetailsDao {
	public void insertUser(UserDetails user) {
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
		public  UserDetails validateUser(String emailId,String password)
		{
			String ValidateQuery="select  * from USER_DETAILS where role='USER'and email='"+emailId+"' and password='"+password+"'";
			Connection con=ConnectionUtil.getDbConnection();
			UserDetails user=null;
			 try {
				 Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(ValidateQuery);
					if(rs.next())
					{
						user=new UserDetails(rs.getString(2),emailId,password,rs.getLong(5));
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
			
		
		public  UserDetails updateUser(UserDetails user )
		{
			 
			String updatequery1="update user_details set name=?,password=? where email=?";
			Connection con=ConnectionUtil.getDbConnection();
			
			try
			{
				PreparedStatement pstmt=con.prepareStatement(updatequery1);
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getEmailId());
				int i=pstmt.executeUpdate();
				System.out.println(i+" user profile updated");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("values not updated");
				System.out.println("something went wrong");
			}
			return user;
		}
		public UserDetails admin(String email_id,String password)
		{
			String AdminQuery="select * from users where role='admin'and email_id='"+email_id+"'and password='"+password+"'";
			
			Connection con=ConnectionUtil.getDbConnection();
			UserDetails user=null;
			try {
				Statement stm =con.createStatement();
				ResultSet rs=stm.executeQuery(AdminQuery);
				if(rs.next())
				{
					 user=new UserDetails(rs.getString(2), email_id, password,rs.getLong(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}
}
	
