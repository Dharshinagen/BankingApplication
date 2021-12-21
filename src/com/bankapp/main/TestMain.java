package com.bankapp.main;

import java.util.List;
import java.util.Scanner;

import com.bankapp.model.AccountDetails;
import com.bankapp.model.UserDetails;
import com.bankapp.dao.AccountDetailsDao;
import com.bankapp.dao.UserDetailsDao;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		UserDetailsDao userDao = null;
		int flag;
		System.out.println("\t WELCOME TO INDIAN BANK");
		System.out.println("\n1.Register\n2.Login\n");
		System.out.println("Enter your choice");
		int choice = Integer.parseInt(sc.nextLine());

		switch (choice) {
		case 1:
			String name, password, email = null;
			userDao = new UserDetailsDao();
			System.out.println("Enter Name:");
			name = sc.nextLine();
			do {
				  if (name.matches("[A-Za-z]{5,}"))
				       {
					      flag = 0;
				          break;
				       } 
				  else {
					      System.out.println("Enter valid name ");
				          name = sc.nextLine();
				          flag = 1;
				       } 
			} while (flag == 1);
			System.out.println("Enter Email");
			email = sc.nextLine();
			do {
				  if (email.matches("[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}"))
				     {
					     flag = 0;
					     break;
				     }
				  else { 
					     System.out.println("Enter valid email ");
				         email = sc.nextLine();
				         flag = 1;
				      } 
			} while (flag == 1);
			System.out.println("enter password:");
			password = sc.nextLine();
			do {
				 if (password.matches("[A-Za-z0-9]{8,10}")) 
				     {
					   flag = 0;
					   break;
				     }
				 else
					{
					   System.out.println("Enter valid password pattern");
					   password = sc.nextLine();
				       flag = 1;
					}
			} while (flag == 1);
			System.out.println("enter password again to confirm:");
			String confirmPassword = sc.nextLine();
			do {
				 if (password.matches(confirmPassword))
				    {
					   flag = 0;
					   break;
				    }
				 else
				    {
					  System.out.println("Please Enter Same Password to Confirm");
					  System.out.println("enter password again to confirm:");
				   	  confirmPassword = sc.nextLine();
					  flag = 1;
				    }
			} while (flag == 1);
			System.out.println("Enter Mobile Number");
			String mobile = sc.nextLine();
			do {
				   if (mobile.matches("[6-9][0-9]{9}"))
				    {
					  flag = 0;
					  break;
				    }
				   else
					{
					   System.out.println("Enter valid Phone no:");
				       mobile = sc.nextLine();
				       flag = 1;
					}
			} while (flag == 1);
			long mobileNumber = Long.parseLong(mobile);
			UserDetails user = new UserDetails(name, email, password, mobileNumber);
			userDao.insertUser(user);
			break;
		case 2:
			userDao = new UserDetailsDao();
			System.out.println("Login");
			System.out.println("Enter Registered Email");
			String emailId = sc.nextLine();

			do {
				    if (emailId.matches("[a-z]+[0-9.]+[@][a-z]+[.][a-z]+{8,15}"))
				     {
          				flag = 0;
					    break;
				     }
				    else
					 {
				    	System.out.println("Enter valid email ");
						emailId = sc.nextLine();
				        flag = 1;
					 }
			} while (flag == 1);

			System.out.println("Enter password:");
			password = sc.nextLine();
			do {
        			if (password.matches("[A-Za-z0-9]{8,10}"))
        			{
					   flag = 0;
					   break;
				    }
        			else
					  {
        				System.out.println("Enter valid password ");
						password = sc.nextLine();
				        flag = 1;
					  }
			} while (flag == 1);
			UserDetails validUser = userDao.validateUser(emailId,password);
			UserDetails ValidAdmin=userDao.admin(emailId,password);
			if (validUser != null)
			   {
				System.out.println("WELCOME\t" + validUser.getName() + "!");
            	System.out.println("\n1.VIEW ACCOUNT DETAIL \n 2.UPDATE YOUR PROFILE");
				System.out.println("ENTER YOUR CHOICE");
                int Choice = Integer.parseInt(sc.nextLine());
				switch (Choice) 
				 {
    			  case 1:
                         AccountDetailsDao accDetailDao = new AccountDetailsDao();
                         System.out.println("ENTER YOUR ACCOUNT NUMBER");
					     String accNumber = sc.nextLine();
					     do {
						      if (accNumber.matches("[0-9]{12}"))
						         {
							      flag = 0;
							      break;
						         }
						      else {
							     System.out.println("Enter valid AccountNo: ");
							     accNumber = sc.nextLine();
							     flag = 1;
						         }
					     } while (flag == 1);
				    	long accNo = Long.parseLong(accNumber);
					    System.out.println("ENTER YOUR ACCOUNT PIN NUMBER");
					    String pinNo = sc.nextLine();
					    do {
						     if (pinNo.matches("[0-9]{4}"))
						     {
							      flag = 0;
						 	      break;
						     } 
						     else {
							      System.out.println("Enter valid Pin Number: ");
							      pinNo = sc.nextLine();
							      flag = 1;
						          }
     					} while (flag == 1);
					    int pinNumber = Integer.parseInt(pinNo);
					    List<AccountDetails> list = accDetailDao.searchDetail(accNo, pinNumber);
					    for (int i = 0; i < list.size(); i++)
					    {
						   System.out.println(list.get(i));
					    }
				        break;
				case 2:
   					   System.out.println("Update Your Profile");
					   userDao = new UserDetailsDao();
					   do {
						   System.out.println("Enter Name you want to change :");
						   name = sc.nextLine();
						   if (name.matches("[A-Za-z]{3,}")) 
						      {
							  flag = 0;
							  break;
						      }
						   else
						      {
							  System.out.println("Enter valid   name");
							  flag = 1;
						      }
					   } while (flag == 1);
					   System.out.println("Enter Email");
					   email = sc.nextLine();
					   do {
						  if (email.matches("[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}")) 
						     {
							  flag = 0;
							  break;
						     }
						  else
							{
							  System.out.println("Enter valid email ");
							  email = sc.nextLine();
						      flag = 1;
							}
					  } while (flag == 1);
				      System.out.println("Enter new Password  :");
					  password = sc.nextLine();
					  do {
						  if (password.matches("[A-Za-z0-9]{8,10}")) 
						   {
							flag = 0;
							break;
						   }
						  else
						   {
							System.out.println("Enter valid password");
							flag = 1;
						   }
			          } while (flag == 1);
					  System.out.println("Enter Confirm Password:");
					  String Confirmpassword = sc.nextLine();
					  do {
						   if (password.equals(Confirmpassword)) 
						   {
							flag = 0;
							break;
						   }
						   else {
							 System.out.println("pls enter confirm password same as password");
						     flag = 1;
		                        }
					} while (flag == 1);
					System.out.println("Enter Mobile Number");
					mobile = sc.nextLine();
					do {
						if (mobile.matches("[6-9][0-9]{9}")) {
							flag = 0;
							break;
						    }
						else
					    	{
							System.out.println("Enter valid Phone no:");
						    mobile = sc.nextLine();
						    flag = 1;
					    	}
					  } while (flag == 1);
					long mobileNum = Long.parseLong(mobile);

					UserDetails user1 = new UserDetails(name, password, emailId, mobileNum);
					userDao.updateUser(user1);
					break;
				 }
				 
			   } //if current user
			   
			 else if(ValidAdmin !=null) 
			 {
				  System.out.println("WELCOME\t" + ValidAdmin.getName() + "!");
	            	System.out.println("\n1.VIEW ALL REGISTERED USER  \n 2.DELETE USER \n 3.UPDATE ACCOUNT DETAILS");
					System.out.println("ENTER YOUR CHOICE");
	                int Choice = Integer.parseInt(sc.nextLine());
					switch (Choice) 
					 {
	    			  case 1:
	    				      
	    				    break;
					 }
			 }
		default:
			System.out.println("Invalid Choice");
			System.exit(0);

		}

	}

}
