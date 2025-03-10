package com.actionImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.actionInterface.UserActionInterface;
import com.ram.entity.Users;

public class UserActionImp implements UserActionInterface {

	public static List<Users> listOfUsers;
	Users loginUser;

	public UserActionImp() {
		listOfUsers = new ArrayList<>();
	}

	public void registerUser(Users user) {
		// TODO Auto-generated method stub
		listOfUsers.add(user);
		System.out.println("User Registerd!");
	}

	public boolean loginUsingCredentials(Scanner scan) {
		System.out.println("Welcome to Login");
		System.out.println("Provide below details:");
		System.out.println("Enter User name :");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.println("Enter Password :");
		String password = scan.nextLine();
		return loginUser(name, password);
	}

	public boolean loginUser(String username, String password) {
		boolean isLogin = false;
		for (Users usr : listOfUsers) {
			if (usr.getUser_name().equals(username) && usr.getPassword().equals(password)) {
				loginUser = usr;
				System.out.println("Login succesfull");
				isLogin = true;
			} else {
				System.out.println("invalid credentials");
			}
		}
		return isLogin;
	}

	public Users getLoginUser() {
		return loginUser;
	}

	public void displayUser() {
		// TODO Auto-generated method stub
		System.out.println(loginUser);
	}

}
