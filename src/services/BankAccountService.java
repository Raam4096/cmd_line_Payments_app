package services;

import java.util.Scanner;

import com.actionImp.BankAccImp;
import com.actionImp.UserActionImp;
import com.ram.entity.BankAccount;

public class BankAccountService {

	public void start(Scanner s, UserActionImp uao, BankAccImp bao) {
		while (true) {
			System.out.println("Choose Below Options :");
			System.out.println("1 . Add Bank Account");
			System.out.println("2 . Remove Bank Account");
			System.out.println("3 . Edit Bank Account Status");
			System.out.println("4 . View Bank Account Details");
			System.out.println("5 . Return to Login Menu");

			int choice = s.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Provide below details to add your bank account");
				System.out.println("Enter your bankaccountId");
				long bankAccountId = s.nextLong();
				System.out.println("Enter your account number");
				long accountNumber = s.nextLong();
				s.nextLine();
				System.out.println("Enter your ifsc code");
				String ifscCode = s.nextLine();
				System.out.println("Enter your account status");
				String actStatus = s.nextLine();
				System.out.println("Enter your bank name");
				String bankname = s.nextLine();
				System.out.println("Enter your branchlocation");
				String bankAccountBranchLocation = s.nextLine();
				BankAccount bankacc = new BankAccount(bankAccountId, accountNumber, ifscCode, actStatus, bankname,
						bankAccountBranchLocation, uao.getLoginUser());
				bao.addAccount(bankacc);
				break;

			case 2:
				System.out.println("Enter the bank account name which you want to remove:");
				s.nextLine();
				bankname = s.nextLine();
				bao.removeAccount(bankname, uao.getLoginUser());
				break;

			case 3:
				System.out.println("Provide below details to edit your bank status");
				System.out.println("Enter your bank name");
				s.nextLine();
				bankname = s.nextLine();
				System.out.println("Enter the status of your bank:");
				String status = s.nextLine();
				bao.editAccStatus(status, bankname, uao.getLoginUser());
				break;

			case 4:
				System.out.println("Provide below details to get you bank account details:");
				System.out.println("Enter your bank name");
				s.nextLine();
				bankname = s.nextLine();
				bao.displayAccDetails(bankname, uao.getLoginUser());
				break;

			case 5:
				break;

			default:
				System.out.println("Invalid choice");

			}
			System.out.println("Do you want to stay in bank menu : y/n");
			char ch = s.next().charAt(0);
			if (ch == 'y') {
				continue;
			} else {
				System.out.println("Going back to login menu");
				break;
			}
		}
	}

}
