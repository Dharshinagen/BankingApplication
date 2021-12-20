package com.bankapp.main;

import java.util.Scanner;

import com.bankapp.dao.AccDetailDao;

public class AccDetailTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		AccDetailDao accDetailDao=new AccDetailDao();
		System.out.println("WELCOME TO INDIAN BANK!");
        System.out.println("ENTER YOUR ACCOUNT NUMBER");
        long accNo=sc.nextLong();
        System.out.println("ENTER YOUR ACCOUNT PIN NUMBER");
        int pinNo=sc.nextInt();
        
        
        AccDetail accdetail= accDetailDao.searchDetail(accNumber,pinNumber);
        
	}

}
