package com.app.main;
import java.util.Scanner;

import com.actionImp.*;
import com.ram.entity.BankAccount;
import com.ram.entity.Users;
public class AppMain {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
        displayStartMenu(s);
	}

	static void displayStartMenu(Scanner s) {
		System.out.println("----------Welcome to Command Line Payments App-----------");
		UserActionImp uao=new UserActionImp();
		boolean flagContinue=true;
		while(flagContinue) {
		System.out.println("1.Register \n2.Login");
		int choice=s.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Welcome to Registration");
			System.out.println("Enter below Details:");
			System.out.print("User Id ");
			int userId=s.nextInt();
			s.nextLine();
			System.out.print("User Name ");
			String userName=s.nextLine();
			System.out.print("Password ");
			String password=s.nextLine();
	        System.out.print("First name ");
			String firstName=s.nextLine();
			System.out.print("Last name ");
			String lastName=s.nextLine();
			System.out.print("mobile ");
			long mobile=s.nextLong();
			s.nextLine();
			System.out.print("email ");
			String email=s.nextLine();
			System.out.print("address ");
			String address=s.nextLine();
			Users user=getUser(userId,userName,password,firstName,lastName,mobile,email,address);
			uao.registerUser(user);
			break;
		case 2:
			System.out.println("Welcome to Login");
			System.out.println("Provide below details:");
			System.out.println("Username :");
			s.nextLine();
			String uname=s.nextLine();
			System.out.println("Password: ");
			String pass=s.nextLine();
			boolean islogin=uao.loginUser(uname,pass);
			if(islogin) {
				System.out.println("Welcome "+uname);
				System.out.println("Login Menu :");
				
				loginMenu(s,uao);
			}
			break;
		default :
			System.out.println("Enter a valid choice");
			
		System.out.println("Wanna continue Y / else N :");
		char ch=s.nextLine().charAt(0);
		if(ch!='y') 
		{
			break;
		}
		else  
		{
			continue;
		}
		  }
		    }
		      }
	
	 static Users getUser(int userId,String userName,String password,String firstname, String lastname,long mobile , String email , String address) 
	  {
		Users user= new Users(userId, userName, password,firstname, lastname,mobile , email , address);
		return user;
	}
	 
	 static void loginMenu(Scanner s,UserActionImp uao) {
		 BankAccImp bao= new BankAccImp();
		 boolean dontstop=true;
		 while(dontstop) {
		 System.out.println("1 . Add Bank Account");
		 System.out.println("2 . View Bank Account");
		 System.out.println("3 . Edit Bank Account Status");
		 System.out.println("4 . Remove Bank account");
		 System.out.println("Enter Your choice");
		 String bankname="";
		 String status="";
		 int choice=s.nextInt();
		 if(choice==1) {
			 System.out.println("Provide below details to add your bank account");
			 System.out.println("Enter your bankaccountId");
			  long bankAccountId=s.nextLong();
			  System.out.println("Enter your account number");
			  long accountNumber=s.nextLong();
			  s.nextLine();
			  System.out.println("Enter your ifsc code");
			  String ifscCode=s.nextLine();
			  System.out.println("Enter your account status");
			  String actStatus=s.nextLine();
			  System.out.println("Enter your bank name");
			  bankname=s.nextLine();
			  System.out.println("Enter your branchlocation");
			  String bankAccountBranchLocation=s.nextLine();
			  BankAccount bankacc=new BankAccount(bankAccountId,accountNumber,ifscCode,actStatus,bankname,bankAccountBranchLocation,uao.getLoginUser());
			  bao.addAccount(bankacc);
		 }
		 else if(choice==2) {
			 System.out.println("Provide below details to get you bank account details:");
			 System.out.println("Enter your bank name");
			 s.nextLine();
			 bankname=s.nextLine();
			 bao.displayAccDetails(bankname, uao.getLoginUser());
		 }
		 else if(choice==3) {
			 System.out.println("Provide below details to edit your bank status");
			 System.out.println("Enter your bank name");
			 s.nextLine();
			 bankname=s.nextLine();
			 System.out.println("Enter the status of your bank:");
			 status=s.nextLine();
			 bao.editAccStatus(status, bankname, uao.getLoginUser());
		 }
		 else if(choice==4) {
			 System.out.println("Enter the bank account name which you want to remove:");
			 s.nextLine();
			 bankname=s.nextLine();
			 bao.removeAccount(bankname, uao.getLoginUser());
		 }
		 else {
			 System.out.println("Invalid choice");
		 }
		 System.out.println("Wanna continue y/ else n");
		 char ch=s.nextLine().charAt(0);
		 if(ch!='y') {
			 break;
		 }
		 else {
			 continue;
		 }
		 }
	 }
	
}
