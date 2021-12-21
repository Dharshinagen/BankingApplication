package com.bankapp.model;

import java.util.Objects;

public class Loans {
         private String loan_type;
         private String description;
         private double Loan_amount;
         private String tenure;
         private double rate_of_interest;
         private double monthly_payment;
		@Override
		public String toString() {
			return "Loans [loan_type=" + loan_type + ", description=" + description + ", Loan_amount=" + Loan_amount
					+ ", tenure=" + tenure + ", rate_of_interest=" + rate_of_interest + ", monthly_payment="
					+ monthly_payment + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(Loan_amount, description, loan_type, monthly_payment, rate_of_interest, tenure);
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
					&& Objects.equals(description, other.description) && Objects.equals(loan_type, other.loan_type)
					&& Double.doubleToLongBits(monthly_payment) == Double.doubleToLongBits(other.monthly_payment)
					&& Double.doubleToLongBits(rate_of_interest) == Double.doubleToLongBits(other.rate_of_interest)
					&& Objects.equals(tenure, other.tenure);
		}
		public Loans() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Loans(String loan_type, String description, double loan_amount, String tenure, double rate_of_interest,
				double monthly_payment) {
			super();
			this.loan_type = loan_type;
			this.description = description;
			Loan_amount = loan_amount;
			this.tenure = tenure;
			this.rate_of_interest = rate_of_interest;
			this.monthly_payment = monthly_payment;
		}
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
		public double getRate_of_interest() {
			return rate_of_interest;
		}
		public void setRate_of_interest(double rate_of_interest) {
			this.rate_of_interest = rate_of_interest;
		}
		public double getMonthly_payment() {
			return monthly_payment;
		}
		public void setMonthly_payment(double monthly_payment) {
			this.monthly_payment = monthly_payment;
		}
}
