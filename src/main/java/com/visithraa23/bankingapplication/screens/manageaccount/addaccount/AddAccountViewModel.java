package com.visithraa23.bankingapplication.screens.manageaccount.addaccount;

import com.visithraa23.bankingapplication.dto.Account;
import com.visithraa23.bankingapplication.repository.BankRepository;

public class AddAccountViewModel {
	private AddAccountView addAccountView;
	private BankRepository bankRepository;

	public AddAccountViewModel(AddAccountView view) {
		addAccountView = view;
		bankRepository = BankRepository.getInstance();
	}

	public void createAccount(String name, String address, String phone, double initialAmount) {
		Account account = bankRepository.createAccount(name, address, phone, initialAmount);
		if (account != null) {
			addAccountView.printOutput("Account Created Succesfully");
			System.out.println(account.getAccountNumber());
			addAccountView.printOutput("\nAccount Number : " + account.getAccountNumber());
			addAccountView.printOutput("Account Holder Name : " + account.getAccountHolderName() + "\n");
		} else {
			addAccountView.printOutput("Already Have an Account.. Not Possible to Create Account..");
		}
	}

}
