package com.actionInterface;

import com.ram.entity.BankAccount;
import com.ram.entity.Users;

public interface BankAccountActionInterface {

	void addAccount(BankAccount b);
	void displayAccDetails(String bankname,Users user);
	void removeAccount(String bankname , Users user);
	void editAccStatus(String status,String bankname,Users user);
}
