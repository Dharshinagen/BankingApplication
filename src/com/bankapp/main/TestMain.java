package com.bankapp.main;

import java.util.Scanner;

import com.bankapp.model.User;
import com.bankapp.dao.UserDao;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
				UserDao userDao = null;
				int flag;
				System.out.println("\t WELCOME TO INDIAN BANK");
				System.out.println("\n1.Register\n2.Login\n");
		        System.out.println("Enter your choice");
			    int choice = Integer.parseInt(sc.nextLine());
			

		switch (choice) {
		case 1:
			userDao = new UserDao();
			System.out.println("Enter Name:");
			String name = sc.nextLine();
			do {
				if (name.matches("[A-Za-z]{5,}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid name ");
				name = sc.nextLine();
				flag = 1;
			} while (flag == 1);
			System.out.println("Enter Email");
			String email = sc.nextLine();
			do {
				if (email.matches("[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid email ");
				email = sc.nextLine();
				flag = 1;
			} while (flag == 1);
			System.out.println("enter password:");
			String password = sc.nextLine();
			do {
				if (password.matches("[A-Za-z0-9]{8,10}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid password pattern");
				password = sc.nextLine();
				flag = 1;
			} while (flag == 1);
			System.out.println("enter password again to confirm:");
			String confirmPassword = sc.nextLine();
			do {
				if (password.matches(confirmPassword))
					flag = 0;
				else {
					System.out.println("Please Enter Same Password to Confirm");
					System.out.println("enter password again to confirm:");
					confirmPassword = sc.nextLine();
					flag = 1;
				}
			} while (flag == 1);
			System.out.println("Enter Mobile Number");
			String mobile = sc.nextLine();
			do {
				if (mobile.matches("[6-9][0-9]{9}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid Phone no:");
				mobile = sc.nextLine();
				flag = 1;
			} while (flag == 1);
			long mobileNumber = Long.parseLong(mobile);
			User user = new User(name, email, password, mobileNumber);
			userDao.insertUser(user);
			break;
		case 2:
			userDao = new UserDao();
			System.out.println("User Login");
			System.out.println("Enter Registered Email");
			String emailId = sc.nextLine();

			do {
				if (emailId.matches("[a-z]+[0-9.]+[@][a-z]+[.][a-z]+{8,15}"))
				{
					 
					flag = 0;
					break;
				} else
					System.out.println("Enter valid email ");
				email = sc.nextLine();
				flag = 1;
			} while (flag == 1);
			
			System.out.println("Enter password:");
			password = sc.nextLine();
			do {
				if (password.matches("[A-Z]+[a-z]+[0-9]+[@#.]+{8,10}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid password ");
				password = sc.nextLine();
				flag = 1;
			} while (flag == 1);

			User validUser = userDao.validateUser(emailId, password);
			if (validUser != null) {
				System.out.println("Welcome\t" + validUser.getName()+"!");
				break;

			}
			 
		case 3:
             System.out.println("Update Your Profile");
			userDao = new UserDao();
			do {
				System.out.println("Enter Name you want to change :");
				 name = sc.nextLine();
				if ( name.matches("[A-Za-z]{3,}")) {
					flag = 0;
					break;
				} else {
					System.out.println("Enter valid   name");
					flag = 1;
				}
			} while (flag == 1);

			do {
				System.out.println("Enter  email u want to change :");
				 email = sc.nextLine();
				if ( email.matches("[a-z]+[0-9.]+[@][a-z]+[.][a-z]+{8,15}")) {
					flag = 0;
					break;
				} else {
					System.out.println("Enter valid email");
					flag = 1;
				}
			} while (flag == 1);

			do {
				System.out.println("Enter new Password  :");
				password = sc.nextLine();
				if (password.matches("[A-Z]+[a-z]+[0-9]+[@#.]+{8,10}")) {
					flag = 0;
					break;
				} else {
					System.out.println("Enter valid password");
					flag = 1;
				}
			} while (flag == 1);

			 

			do {
				System.out.println("Enter Confirm Password:");
			     String	Confirmpassword = sc.nextLine();
				if (password.equals(Confirmpassword)) {
					flag = 0;
					break;
				} else {
					System.out.println("pls enter confirm password same as password");
					flag = 1;
				}
			} while (flag == 1);

			user = new User(name,email,password,mobile);
			userdao.updateUser(user);
		default:
			System.out.println("Invalid Choice ");
			System.exit(0);

		}
		 
	}

}
