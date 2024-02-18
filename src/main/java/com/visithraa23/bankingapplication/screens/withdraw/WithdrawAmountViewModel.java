package com.visithraa23.bankingapplication.screens.withdraw;

import com.visithraa23.bankingapplication.dto.Account;
import com.visithraa23.bankingapplication.repository.BankRepository;

public class WithdrawAmountViewModel {
	private WithdrawAmountView withdrawView;
	private BankRepository bankRepository;

	public WithdrawAmountViewModel(WithdrawAmountView view) {
		withdrawView = view;
		bankRepository = BankRepository.getInstance();
	}

	public void withdrawlAmount(String accountNumber, double amount) {
		Account account = bankRepository.checkAccountNumber(accountNumber);
		if (account != null) {
			if (amount <= account.getBalance()) {
				if (bankRepository.withdrawlAmount(amount, account)) {
					withdrawView.printOutput("Amount Withdrawl Successfully...");
				} else {
					withdrawView.printOutput("Something went wrong... Try Again Later..");
				}
			} else {
				withdrawView.printOutput("Insufficient Balance");
			}
		} else {
			withdrawView.printOutput("Account Not Found..");
		}
	}

}
