package com.actionImp;

import java.util.ArrayList;
import java.util.List;

import com.actionInterface.UserActionInterface;
import com.ram.entity.Users;

public class UserActionImp implements UserActionInterface {
    
	List<Users> listOfUsers;
	Users loginUser;
	public UserActionImp(){
		listOfUsers=new ArrayList<>();
	}
	
	public void registerUser(Users user) {
		// TODO Auto-generated method stub
		listOfUsers.add(user);
		System.out.println("User Registerd!");
	}


	public boolean loginUser(String username, String password) {
		boolean islogin=false;
		for(Users usr:listOfUsers) {
			if(usr.getUser_name().equals(username)&&usr.getPassword().equals(password)) {
				loginUser=usr;
				System.out.println("Login succesfull");
				islogin=true;
			}
			else {
				System.out.println("invalid credentials");
			}
		}
		return islogin;
	}


	public Users getLoginUser() {
		return loginUser;
	}

	

	public void displayUser() {
		// TODO Auto-generated method stub
		
	}

}
