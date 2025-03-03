
package com.ram.entity;

public class BankAccount {

	private final long bank_account_id ;
	private final long account_number ;
	private final String ifsc_code;
	private String actStatus;
	private final String bank_name;
	private final String bank_account_branch_location;
	private final Users user;
	
	public BankAccount(long bank_account_id, long account_number, String ifsc_code, String actStatus, String bank_name,
			String bank_account_branch_location, Users user) {
		super();
		this.bank_account_id = bank_account_id;
		this.account_number = account_number;
		this.ifsc_code = ifsc_code;
		this.actStatus = actStatus;
		this.bank_name = bank_name;
		this.bank_account_branch_location = bank_account_branch_location;
		this.user = user;
	}
	
	public long getBank_account_id() {
		return bank_account_id;
	}
	public long getAccount_number() {
		return account_number;
	}
		
	public String getIfsc_code() {
		return ifsc_code;
	}
	
	public String getActStatus() {
		return actStatus;
	}
	public void setActStatus(String actStatus) {
		this.actStatus = actStatus;
	}
	public String getBank_name() {
		return bank_name;
	}
	
	public String getBank_account_branch_location() {
		return bank_account_branch_location;
	}
	
	public Users getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "BankAccount [bank_account_id=" + bank_account_id + ", account_number=" + account_number + ", ifsc_code="
				+ ifsc_code + ", actStatus=" + actStatus + ", bank_name=" + bank_name
				+ ", bank_account_branch_location=" + bank_account_branch_location + "]";
	}
	
	
	
}

