package com.bankapp.model;

import java.util.Objects;

public class AccDetail {
	private long accNumber;
	private int pinNumber;
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public AccDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccDetail(long accNumber, int pinNumber) {
		super();
		this.accNumber = accNumber;
		this.pinNumber = pinNumber;
	}
	@Override
	public String toString() {
		return "AccDetail [accNumber=" + accNumber + ", pinNumber=" + pinNumber + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(accNumber, pinNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccDetail other = (AccDetail) obj;
		return accNumber == other.accNumber && pinNumber == other.pinNumber;
	}

}
