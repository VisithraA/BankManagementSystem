package com.visithraa23.bankingapplication.screens.deposit;

import com.visithraa23.bankingapplication.dto.Account;
import com.visithraa23.bankingapplication.repository.BankRepository;

public class DepositAmountViewModel {
	private DepositAmountView depositView;
	private BankRepository bankRepository;

	public DepositAmountViewModel(DepositAmountView depositAmountView) {
		depositView = depositAmountView;
		bankRepository = BankRepository.getInstance();
	}

	public void depositAmount(String accountNumber, double amount) {
		Account account = bankRepository.checkAccountNumber(accountNumber);
		if (account != null) {
			if (bankRepository.depositAmount(amount, account)) {
				depositView.printOutput("Amount Deposited Successfully..");
			} else {
				depositView.printOutput("Something went Wrong.. Try Again Later..");
			}
		} else {
			depositView.printOutput("Account Number Not Found..");
		}
	}

}
