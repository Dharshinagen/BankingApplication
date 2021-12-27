package com.bankapp.model;

import java.util.Objects;

public class AccountDetails {
	private int  user_id;
	private String account_type;
	private String account_Holder_name;
	private String address;
	private String city;
	private int pincode;
	private String dob;
	private long mobile_Number;
	private String email;
	private String ifsc_Code;
	private String branchName;
	private int balance;	
	private int pin_Number;
	public int getId() {
		return user_id;
	}
	public void setId(int id) {
		this.user_id = id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAccount_Holder_name() {
		return account_Holder_name;
	}
	public void setAccount_Holder_name(String account_Holder_name) {
		this.account_Holder_name = account_Holder_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getMobile_Number() {
		return mobile_Number;
	}
	public void setMobile_Number(long mobile_Number) {
		this.mobile_Number = mobile_Number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIfsc_Code() {
		return ifsc_Code;
	}
	public void setIfsc_Code(String ifsc_Code) {
		this.ifsc_Code = ifsc_Code;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getPin_Number() {
		return pin_Number;
	}
	public void setPin_Number(int pin_Number) {
		this.pin_Number = pin_Number;
	}
	public AccountDetails(int id, String account_type, String account_Holder_name, String address, String city,
			int pincode, String dob, long mobile_Number, String email, String ifsc_Code, String branchName, int balance,
			int pin_Number) {
		super();
		this.user_id = id;
		this.account_type = account_type;
		this.account_Holder_name = account_Holder_name;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.dob = dob;
		this.mobile_Number = mobile_Number;
		this.email = email;
		this.ifsc_Code = ifsc_Code;
		this.branchName = branchName;
		this.balance = balance;
		this.pin_Number = pin_Number;
	}
	  
	 


	@Override
	public int hashCode() {
		return Objects.hash(account_Holder_name, account_type, address, balance, branchName, city, dob, email, user_id,
				ifsc_Code, mobile_Number, pin_Number, pincode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDetails other = (AccountDetails) obj;
		return Objects.equals(account_Holder_name, other.account_Holder_name)
				&& Objects.equals(account_type, other.account_type) && Objects.equals(address, other.address)
				&& balance == other.balance && Objects.equals(branchName, other.branchName)
				&& Objects.equals(city, other.city) && Objects.equals(dob, other.dob)
				&& Objects.equals(email, other.email) && user_id == other.user_id && Objects.equals(ifsc_Code, other.ifsc_Code)
				&& mobile_Number == other.mobile_Number && pin_Number == other.pin_Number && pincode == other.pincode;
	}
	@Override
	public String toString() {
		return "\t AccountDetails\n"+ "\nAccount Type : " + account_type + "\nAccount Holder name : "
				+ account_Holder_name + "\nAddress : " + address + "\nCity : " + city + "\nPincode : " + pincode + "\nDob : "
				+ dob + "\nMobile Number : " + mobile_Number + "\nEmailId:" + email + "\nIFSC Code : " + ifsc_Code
				+ "\nBranchName : " + branchName + "\nBalance : " + balance ;
	}
	 
	 


}
