package com.bankapp.main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.bankapp.model.AccountDetails;
import com.bankapp.model.UserDetails;
import com.bankapp.dao.AccountDetailsDao;
import com.bankapp.dao.DepositsDao;
import com.bankapp.dao.LoansDao;
import com.bankapp.dao.TransactionDao;
import com.bankapp.dao.UserDetailsDao;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		UserDetailsDao userDao = null;
		int flag;
		int user_id=0;
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
			AccountDetailsDao accountsDao = new AccountDetailsDao();
			String id = accountsDao.getUserId(email);
			if( id !=null )
			{
				Long account_id = Long.parseLong(id);
				UserDetails user = new UserDetails(name, email, password, mobileNumber, account_id);
				userDao.insertUser(user);				
			}
			else {
				System.out.println("Invalid Email");
			}
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
			do
			{
			UserDetails ValidAdmin=userDao.admin(emailId,password);
			UserDetails validUser =userDao.validateUser(emailId,password);
		
			if (validUser != null)
			   {
				user_id=validUser.getUser_id();
				System.out.println("WELCOME\t" + validUser.getUser_name() + "!");
            	System.out.println("\n1.VIEW ACCOUNT DETAIL \n2.UPDATE YOUR PROFILE \n3.Transaction \n4.DepositType \n5.Loans");
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
							  name = sc.nextLine();
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
							password = sc.nextLine();
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
							 Confirmpassword = sc.nextLine();
						     flag = 1;
		                        }
					} while (flag == 1);
					System.out.println("Enter Email");
					 email = sc.nextLine();
					 userDao.updateUser(name,password,email);
					break;
				case 3:
				 TransactionDao	 transDao = new TransactionDao();
					System.out.println("Transaction");
					System.out.println("\n1.Deposit Amount \n2. Withdraw Amount \n3.View Balance" );
					System.out.println("Enter Your Choice");
					choice = Integer.parseInt(sc.nextLine());
					    switch(choice) {
					         case 1:
					        	   System.out.println("Enter your name");
					        	   name=sc.nextLine();
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
					        	   System.out.println("Enter your Account number:");
					        	   String account_number=sc.nextLine();
					        	   do {
									      if (account_number.matches("[0-9]{12}"))
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
							    	 long Sender_accuntNo = Long.parseLong(account_number);
					        	     System.out.println("Enter the Amount to DEposit");
					        	     double amount=Double.parseDouble(sc.nextLine());
					        	     do {
					        	    	     if(amount>=200)
					        	    	     {
					        	    	    	 flag=0;
					        	    	    	 break;
					        	    	     }
					        	    	     else
					        	    	     {
					        	    	    	 System.out.println("Enter Amount Greater Than 200");
					        	    	    	 System.out.println("Enter the Amount to Deposit");
									        	 amount=Double.parseDouble(sc.nextLine());
									        	  flag=1;
					        	    	     }
					        	     }while(flag==1);
					        	      System.out.println("Enter Pin Number");
					        	      pinNo = sc.nextLine();
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
								      int pin_Number = Integer.parseInt(pinNo);
					        	      System.out.println("Enter the Receiver Account number  :");
					        	      String receiver_Account_Number=sc.nextLine();
					        	      do {
									         if (receiver_Account_Number.matches("[0-9]{12}"))
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
							    	  long  receiver_AccountNo = Long.parseLong(receiver_Account_Number );
							    	  transDao.depositAmount(Sender_accuntNo,amount,pin_Number,receiver_AccountNo );
					        	   
					        	      break;
					         case 2:
					        	      System.out.println("Withdraw Amount");
					        	      System.out.println("Enter Account Number");
					        	      String account_Number=sc.nextLine();
					        	      do {
									         if (account_Number.matches("[0-9]{12}"))
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
							    	  long  acc_num = Long.parseLong(account_Number);
								        System.out.println("Enter the Amount to withdraw");
						        	     amount=Double.parseDouble(sc.nextLine());
						        	     do {
						        	    	     if(amount>=500)
						        	    	     {
						        	    	    	 flag=0;
						        	    	    	 break;
						        	    	     }
						        	    	     else
						        	    	     {
						        	    	    	 System.out.println("Enter Amount Greater Than 500");
						        	    	    	 System.out.println("Enter the Amount to DEposit");
										        	 amount=sc.nextDouble();
										        	  flag=1;
						        	    	     }
						        	     }while(flag==1);
						        	      System.out.println("Enter Pin Number");
						        	      pinNo = sc.nextLine();
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
									        pin_Number = Integer.parseInt(pinNo);
									        transDao.withdrawAmount(acc_num, amount, pin_Number);
									        
					        	      break;
					         case 3:
					        	 System.out.println("View Acccount Balance");
					        	 System.out.println("Enter Account Number");
				        	      account_Number=sc.nextLine();
				        	      do {
								         if (account_Number.matches("[0-9]{12}"))
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
						    	  long  acc_number = Long.parseLong(account_Number);
						    	  System.out.println("Enter Pin Number");
				        	      pinNo = sc.nextLine();
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
							        pin_Number = Integer.parseInt(pinNo);
							       double balance= transDao.viewBalance(acc_number, pin_Number);
							       System.out.println("BALANCE : "+balance);
					        	 break;
					    }
					    break;
				case 4:
					 System.out.println("Deposit Type");
					 System.out.println("1.FIXED DEPOSIT \n2.RECURRING DEPOSIT");
					 System.out.println("Enter your Choice");
					 DepositsDao depositDao=new DepositsDao();
					  Choice =Integer.parseInt(sc.nextLine());
					   switch(Choice)
					   {
					   case 1:
						   String type="Fixed Deposit";
						   String status="not approved";
						    double rate_of_interest = 0;
						     System.out.println("Enter the Amount to be deposited");
						     double amount=Double.parseDouble(sc.nextLine());
						     System.out.println(" Enter Period ");
						      long t_period=Long.parseLong(sc.nextLine());
						      int n=0;
						     if(t_period <=2) {
						    	   n=1;
						        rate_of_interest  = depositDao.getInterest(1.1);
						     }
						     else if(t_period >2) {
						    	  n=1;
						    	 rate_of_interest=depositDao.getInterest(1.2);
						     }
						     else
						    	 System.out.println("invalid Period");
						     
						     double base=(1+(rate_of_interest /n));
						     double maturity_value=amount +Math.pow(base,(n* t_period));
						     depositDao.fixedDeposit(type,amount,rate_of_interest,maturity_value,t_period,status,user_id);
						     break;
					   case 2:
						    
							 DepositsDao depositsDao=new DepositsDao();
						     rate_of_interest = 0;
						     String type1="Recurring Deposit";
						     String status1="Not Approved";
						    System.out.println("Enter the Amount to be deposited");
						    long amount1=Long.parseLong(sc.nextLine());
						    System.out.println("Enter the period");
							t_period=Long.parseLong(sc.nextLine());
								        n=0;
								     if(t_period <=2) {
								    	   n=1;
								        rate_of_interest  = depositDao.getInterest(2.1);
								     }
								     else if(t_period >2) {
								    	  n=1;
								    	 rate_of_interest=depositDao.getInterest(2.2);
								     }
								     else
								    	 System.out.println("invalid Period");
								     
								       base=(1+(rate_of_interest /n));
								       maturity_value=amount1 +Math.pow(base,(n* t_period));
							     depositsDao.recurringDeposit(type1,amount1,t_period,rate_of_interest,maturity_value,status1,user_id);
								     break;
							   }
					      break;
				        
				case 5:
					LoansDao loansDao=new LoansDao();
					System.out.println("Loan Details");
					System.out.println("\n1.Personal Loan\n2.Housing Loan");
					System.out.println("Enter your Choice");
					int ch=Integer.parseInt(sc.nextLine());
					switch(ch)
					{
					case 1:
					     String type="Personal loan";
					     String status1="Not Approved";
				    	  System.out.println("Enter Loan amount needed:");
				    	  double amount=Double.parseDouble(sc.nextLine());
						  System.out.println(" Enter Period ");
						  double t_period=Double.parseDouble(sc.nextLine());
						  System.out.println("Enter your Working Type(Tier-I,Tier-II,Self Employee");
						  String d_type=sc.nextLine();
						      int n=0;
						      double rate_of_interest=0;
						     if(d_type.matches("Tier-I")) {
						    	   n=1;
						        rate_of_interest  = loansDao.getInterest(3.1);
						     }
						     else if(d_type.matches("Tier-II")) {
						    	  n=1;
						    	 rate_of_interest=loansDao.getInterest(3.2);
						     }
						     else if(d_type.matches("Self Employee")) {
						    	 n=1;
						    	 rate_of_interest=loansDao.getInterest(3.3);
						     }
						     else
						    	 System.out.println("invalid Period");
						     System.out.println("Enter No Of Payments (12,18,24)");
						      double numberOfPayments=Integer.parseInt(sc.nextLine());
						      
						      
						     double r=Math.pow((1+rate_of_interest), numberOfPayments);
						     double monthly_payment= amount *rate_of_interest*((r)/(r-1));
						    // System.out.println(monthly_payment);
					 	     loansDao.PersonalLoan(type,amount,t_period,d_type,rate_of_interest,monthly_payment,user_id,status1);
					 	     break;
					case 2:
						  type="Housing loan";
					       status1="Not Approved";
					       d_type="Housing Loan";
				    	  System.out.println("Enter Loan amount needed:");
				    	    amount=Double.parseDouble(sc.nextLine());
						  System.out.println(" Enter Period ");
						  t_period=Long.parseLong(sc.nextLine());
						   rate_of_interest=0;rate_of_interest  = loansDao.getInterest(3.3);
						   System.out.println("Enter No Of Payments (12,18,24)");
						        numberOfPayments=Integer.parseInt(sc.nextLine());
						      
						      
						      r=Math.pow((1+rate_of_interest), numberOfPayments);
						      monthly_payment= amount *rate_of_interest*((r)/(r-1));
						    // System.out.println(monthly_payment);
					 	     loansDao.housingLoan(type,amount,t_period,d_type,rate_of_interest,monthly_payment,user_id,status1);
					 	     break;
						     
						     
					}
					break;
				 }
			   }//if current user
			   
			 else if(ValidAdmin !=null) 
			 {
				  System.out.println("WELCOME\t" + ValidAdmin.getUser_name() + "!");
	            	System.out.println("\n1.VIEW ALL REGISTERED USER  \n2.CANCEL USER \n3.UPDATE ACCOUNT DETAILS \n4.CANCEL ACCOUNT");
					System.out.println("ENTER YOUR CHOICE");
	                int Choice = Integer.parseInt(sc.nextLine());
	                userDao=null;
					switch (Choice) 
					 {
	    			  case 1:
	    				    userDao =new UserDetailsDao();
	    				    List<UserDetails> userList= userDao.viewUser();
	    				    for(int i=0;i< userList.size();i++) {
	    				    	System.out.println(userList.get(i));
	    				    }
	    				    break;
	    			  case 2:
	    				 userDao = new UserDetailsDao();
	    				 System.out.println("enter email to delete: ");
	    				 String email1 =sc.nextLine();
	    				 userDao.deleteDetails(email1);
	    				 
	    				break;
	    			  case 3:
	    				  System.out.println("Update User Account Details");
	    				  System.out.println("Enter  EmailId to be updated");
	    					emailId = sc.nextLine();

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
	    					System.out.println("Enter Mobile Number to be updated:");
	    					 mobile = sc.nextLine();
	    					do {
	    						   if (mobile.matches("[6-9][0-9]{9}"))
	    						    {
	    							  flag = 0;
	    							  break;
	    						    }
	    						   else
	    							{
	    							   System.out.println("Enter valid mobile no:");
	    						       mobile = sc.nextLine();
	    						       flag = 1;
	    							}
	    					} while (flag == 1);
	    					long mobileNum = Long.parseLong(mobile);
	    					System.out.println("Enter  Previous EmailId ");
	    					 String email_Id = sc.nextLine();

	    					do {
	    						    if (email_Id.matches("[a-z]+[0-9.]+[@][a-z]+[.][a-z]+{8,15}"))
	    						     {
	    		          				flag = 0;
	    							    break;
	    						     }
	    						    else
	    							 {
	    						    	System.out.println("Enter valid email ");
	    								email_Id = sc.nextLine();
	    						        flag = 1;
	    							 }
	    					} while (flag == 1);
	    					AccountDetailsDao accountDetailDao=new AccountDetailsDao();
	    					accountDetailDao.updateUserDetailAdmin(emailId, mobileNum, email_Id);
	    				   break;
	    			  case 4:
	    				  System.out.println("Delete Account");
	    				  System.out.println("Enter the Account Number to delete");
	    				  String  account_number=sc.nextLine();
			        	   do {
							      if (account_number.matches("[0-9]{12}"))
							         {
								      flag = 0;
								      break;
							         }
							      else {
								     System.out.println("Enter valid AccountNo: ");
								     account_number= sc.nextLine();
								     flag = 1;
							         }
						     } while (flag == 1);
					    	 long  accuntNo = Long.parseLong(account_number);
					    	 AccountDetailsDao accountDetailDao1=new AccountDetailsDao();
					    	 accountDetailDao1.deleteDetails(accuntNo);
	    				  
	    				  break;
	    			  case 5:
	    				   break;
					 }
			 }
			 else
				 System.out.println("Not a Valid user");
				 flag=0;
			break; 
			}while(flag==0);
			break;
		 
			
		default:
			System.out.println("Invalid Choice");
			System.exit(0);

		}

	}

}
