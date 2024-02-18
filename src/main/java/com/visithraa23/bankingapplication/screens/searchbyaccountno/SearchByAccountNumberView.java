package com.visithraa23.bankingapplication.screens.searchbyaccountno;

import java.util.List;
import java.util.Scanner;

import com.visithraa23.bankingapplication.dto.Account;

public class SearchByAccountNumberView {
	private SearchByAccountNumberViewModel searchViewModel;

	public SearchByAccountNumberView() {
		searchViewModel = new SearchByAccountNumberViewModel(this);
	}

	public void searchByAccountNo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account Number : ");
		String accountNumber = sc.next();
		List<Account> list = searchViewModel.searchByAccountNo(accountNumber);

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
