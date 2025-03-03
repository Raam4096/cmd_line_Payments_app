package com.actionInterface;

import com.ram.entity.Users;

public interface UserActionInterface {

	void registerUser(Users user);
	boolean loginUser(String username , String password);
	void displayUser();
}
