package com.app.main;

import java.util.Scanner;

import com.actionImp.*;
import com.ram.entity.Users;

import services.BankAccountService;

public class AppMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		displayStartMenu(s);
	}

	static void displayStartMenu(Scanner s) {
		System.out.println("----------Welcome to Command Line Payments App-----------");
		UserActionImp uao = new UserActionImp();
		boolean flagContinue = true;
		Users user;
		while (flagContinue) {
			System.out.println("1.Register 2.Login 3.View all Users 4.Exit");
			int choice = s.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Welcome to Registration");
				System.out.println("Enter below Details:");
				s.nextLine();
				System.out.print("User Name ");
				String userName = s.nextLine();
				System.out.print("Password ");
				String password = s.nextLine();
				System.out.print("First name ");
				String firstName = s.nextLine();
				System.out.print("Last name ");
				String lastName = s.nextLine();
				System.out.print("mobile ");
				String mobile = s.nextLine();
				System.out.print("email ");
				String email = s.nextLine();
				System.out.print("address ");
				String address = s.nextLine();
				user = getUser(userName, password, firstName, lastName, mobile, email, address);
				uao.registerUser(user);
				break;

			case 2:
				boolean isLogin = uao.loginUsingCredentials(s);
				if (isLogin) {
					while (true) {
						loginMenu(s, uao);
						System.out.println("Wanna continue Login menu : y/n");
						char ch1 = s.next().charAt(0);
						if (ch1 == 'y') {
							continue;
						} else {
							System.out.println("Incorrect Login Credentials");
							break;
						}
					}
				}
				break;

			case 3:
				if (UserActionImp.listOfUsers.size() != 0)
					System.out.println("Current registered Users " + UserActionImp.listOfUsers.size());
				else {
					System.out.println("There are no registered users");
				}
				break;

			case 4:
				break;

			default:
				System.out.println("Enter a valid choice");
			}
			System.out.println("Wanna continue Main Menu : Y / N :");
			char ch = s.next().charAt(0);
			if (ch != 'y') {
				System.out.println("Exiting.... \nThank You!");
				flagContinue = false;
			} else {
				flagContinue = true;
			}
		}
	}

	static Users getUser(String userName, String password, String firstname, String lastname, String mobile,
			String email, String address) {
		Users user = new Users(userName, password, firstname, lastname, mobile, email, address);
		return user;
	}

	static void loginMenu(Scanner s, UserActionImp uao) {
		BankAccImp bao = new BankAccImp();
		System.out.println("1. Profile");
		System.out.println("2. Bank Accounts");
		System.out.println("3. Transactions Data");
		System.out.println("4. Send Money");
		System.out.println("Enter Your choice");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Below are your profile details");
			uao.displayUser();
			break;
		case 2:
			BankAccountService bankAS = new BankAccountService();
			bankAS.start(s, uao, bao);
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			System.out.println("Invalid Choice");
		}
	}

}
