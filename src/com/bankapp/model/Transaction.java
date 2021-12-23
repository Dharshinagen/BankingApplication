package com.bankapp.model;

import java.util.Objects;

public class Transaction {
             private String ifsc_code;
             private String transaction_type;
             private long amount;
             private long balance;
             private String transaction_status;
			public String getIfsc_code() {
				return ifsc_code;
			}
			public void setIfsc_code(String ifsc_code) {
				this.ifsc_code = ifsc_code;
			}
			public String getTransaction_type() {
				return transaction_type;
			}
			public void setTransaction_type(String transaction_type) {
				this.transaction_type = transaction_type;
			}
			public long getAmount() {
				return amount;
			}
			public void setAmount(long amount) {
				this.amount = amount;
			}
			public long getBalance() {
				return balance;
			}
			public void setBalance(long balance) {
				this.balance = balance;
			}
			public String getTransaction_status() {
				return transaction_status;
			}
			public void setTransaction_status(String transaction_status) {
				this.transaction_status = transaction_status;
			}
			public Transaction(String ifsc_code, String transaction_type, long amount, long balance,
					String transaction_status) {
				super();
				this.ifsc_code = ifsc_code;
				this.transaction_type = transaction_type;
				this.amount = amount;
				this.balance = balance;
				this.transaction_status = transaction_status;
			}
			public Transaction() {
				super();
				// TODO Auto-generated constructor stub
			}
			@Override
			public int hashCode() {
				return Objects.hash(amount, balance, ifsc_code, transaction_status, transaction_type);
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Transaction other = (Transaction) obj;
				return amount == other.amount && balance == other.balance && Objects.equals(ifsc_code, other.ifsc_code)
						&& Objects.equals(transaction_status, other.transaction_status)
						&& Objects.equals(transaction_type, other.transaction_type);
			}
			@Override
			public String toString() {
				return "Transaction [ifsc_code=" + ifsc_code + ", transaction_type=" + transaction_type + ", amount="
						+ amount + ", balance=" + balance + ", transaction_status=" + transaction_status + "]";
			}


}
