package com.bankapp.model;

import java.util.Objects;

public class Loans {
         private String loan_type;
         private String description;
         private double Loan_amount;
         private String tenure;
         private double interest_rate;
         private double monthly_payment;
         private String loan_status;
		public String getLoan_type() {
			return loan_type;
		}
		public void setLoan_type(String loan_type) {
			this.loan_type = loan_type;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getLoan_amount() {
			return Loan_amount;
		}
		public void setLoan_amount(double loan_amount) {
			Loan_amount = loan_amount;
		}
		public String getTenure() {
			return tenure;
		}
		public void setTenure(String tenure) {
			this.tenure = tenure;
		}
		public double getInterest_rate() {
			return interest_rate;
		}
		public void setInterest_rate(double interest_rate) {
			this.interest_rate = interest_rate;
		}
		public double getMonthly_payment() {
			return monthly_payment;
		}
		public void setMonthly_payment(double monthly_payment) {
			this.monthly_payment = monthly_payment;
		}
		public String getLoan_status() {
			return loan_status;
		}
		public void setLoan_status(String loan_status) {
			this.loan_status = loan_status;
		}
		public Loans(String loan_type, String description, double loan_amount, String tenure, double interest_rate,
				double monthly_payment, String loan_status) {
			super();
			this.loan_type = loan_type;
			this.description = description;
			this.Loan_amount = loan_amount;
			this.tenure = tenure;
			this.interest_rate = interest_rate;
			this.monthly_payment = monthly_payment;
			this.loan_status = loan_status;
		}
		public Loans() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public int hashCode() {
			return Objects.hash(Loan_amount, description, interest_rate, loan_status, loan_type, monthly_payment,
					tenure);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Loans other = (Loans) obj;
			return Double.doubleToLongBits(Loan_amount) == Double.doubleToLongBits(other.Loan_amount)
					&& Objects.equals(description, other.description)
					&& Double.doubleToLongBits(interest_rate) == Double.doubleToLongBits(other.interest_rate)
					&& Objects.equals(loan_status, other.loan_status) && Objects.equals(loan_type, other.loan_type)
					&& Double.doubleToLongBits(monthly_payment) == Double.doubleToLongBits(other.monthly_payment)
					&& Objects.equals(tenure, other.tenure);
		}
		@Override
		public String toString() {
			return "Loans [loan_type=" + loan_type + ", description=" + description + ", Loan_amount=" + Loan_amount
					+ ", tenure=" + tenure + ", interest_rate=" + interest_rate + ", monthly_payment=" + monthly_payment
					+ ", loan_status=" + loan_status + "]";
		}
		


}
