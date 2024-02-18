package com.visithraa23.bankingapplication.screens.displayallaccounts;

import java.util.List;

import com.visithraa23.bankingapplication.dto.Account;

public class DisplayAllAccountView {
	private DisplayAllAccountViewModel displayAllAccountViewModel;

	public DisplayAllAccountView() {
		displayAllAccountViewModel = new DisplayAllAccountViewModel(this);
	}

	public void displayAllAccount() {
		List<Account> list = displayAllAccountViewModel.displayAllAccount();

		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("| %-10s | %-20s | %-20s | %-15s | %-15s | %-30s |\n", "Account No", "Holder Name", "Address",
				"Phone", "Balance", "Open Date");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------");

		if (list != null) {
			for (Account account : list) {
				System.out.printf("| %-10s | %-20s | %-20s | %-15s | %-15s | %-30s |\n", account.getAccountNumber(),
						account.getAccountHolderName(), account.getAddress(), account.getPhone(), account.getBalance(),
						account.getOpenDate());
			}

		} else {
			System.out.printf("| %-60s No Found %-61s|\n", "", "");
		}

		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------\n");

	}

}
