package com.bankapp.model;

import java.util.Objects;

public class UserDetails {
	 private String name;
	 private String emailId;
     private String password;
	 private long mobile_Number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(mobile_Number, emailId, name, password);
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
		return mobile_Number == other.mobile_Number && Objects.equals(emailId, other.emailId)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", emailId=" + emailId + ", password=" + password + ", MobileNumber="
				+ mobile_Number + "]";
	}
	public UserDetails(String name, String emailId, String password, long mobileNumber) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		mobileNumber = mobileNumber;
	}
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobileNumber() {
		return mobile_Number;
	}
	public void setMobileNumber(long mobileNumber) {
		mobileNumber = mobileNumber;
	} 
 }