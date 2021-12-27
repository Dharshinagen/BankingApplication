package com.bankapp.model;

import java.util.Objects;

public class UserDetails {
	private int user_id;
	private String user_name;
	private String emailId;
	private String user_password;
	private long mobile_Number;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public long getMobile_Number() {
		return mobile_Number;
	}

	public void setMobile_Number(long mobile_Number) {
		this.mobile_Number = mobile_Number;
	}
     
	public UserDetails(int user_id, String user_name, String emailId, String user_password, long mobile_Number) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.emailId = emailId;
		this.user_password = user_password;
		this.mobile_Number = mobile_Number;
	}
	public UserDetails( String user_name, String emailId, String user_password, long mobile_Number) {
		super();
		 
		this.user_name = user_name;
		this.emailId = emailId;
		this.user_password = user_password;
		this.mobile_Number = mobile_Number;
	}

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(emailId, mobile_Number, user_id, user_name, user_password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		return Objects.equals(emailId, other.emailId) && mobile_Number == other.mobile_Number
				&& user_id == other.user_id && Objects.equals(user_name, other.user_name)
				&& Objects.equals(user_password, other.user_password);
	}

	@Override
	public String toString() {
		return String.format("%-15s%-15s%-20s%-15s", user_name, emailId, user_password, mobile_Number);
	}
}