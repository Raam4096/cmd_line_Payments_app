package com.actionImp;


import com.actionInterface.BankAccountActionInterface;
import com.ram.entity.BankAccount;
import com.ram.entity.Users;

public class BankAccImp implements BankAccountActionInterface {

	public void addAccount(BankAccount b) {
		// TODO Auto-generated method stub
		b.getUser().setBanks(b);
		System.out.println("Successfully account added");
	}

	public void displayAccDetails(String bankname, Users user) {
		boolean found = false;
		// TODO Auto-generated method stub
		for (BankAccount bank : user.getBanks()) {
			if (bank.getBank_name().equals(bankname)) {
				System.out.println(bank);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No bank found");
		}
	}

	public void removeAccount(String bankname, Users user) {
		// TODO Auto-generated method stub
		for (BankAccount ac : user.getBanks()) {
			if (ac.getBank_name().equals(bankname)) {
				user.getBanks().remove(ac);
			}
		}
		System.out.println("Bank removed successfully");
	}

	public void editAccStatus(String status, String bankname, Users user) {
		// TODO Auto-generated method stub
		for (BankAccount ac : user.getBanks()) {
			if (ac.getBank_name().equals(bankname)) {
				ac.setActStatus(status);
			}
		}
		System.out.println("Status updated");
	}

}
