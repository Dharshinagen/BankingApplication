package com.bankapp.dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.model.AccountDetails;
import com.bankapp.model.UserDetails;

public class AccountDetailsDao {

	public List<AccountDetails> searchDetail(long accNumber,int pinNumber) {
		List<AccountDetails> list=new ArrayList<AccountDetails>();
		ConnectionUtil conUtil = new ConnectionUtil();
		
		String ValidateQuery="select * from ACCOUNT_DETAILS WHERE  ACCOUNT_NUMBER='"+accNumber+"' and PIN_NUMBER='"+ pinNumber+"'";
		 
		Connection con = conUtil.getDbConnection();
		AccountDetails accDetail=null;
		try {
			 Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(ValidateQuery);
				 
				if(rs.next())
				{
					accDetail=new AccountDetails ( rs.getInt(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
							rs.getInt(7),rs.getString(8),rs.getLong(9),rs.getString(10),
							rs.getString(11),rs.getString(12),rs.getInt(13),rs.getInt(14) );
					list.add(accDetail);
				}
				else {
					System.out.println("Not a valid user");
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement Error");
		}
		return  list; 
	}
}
