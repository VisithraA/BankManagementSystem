package com.visithraa23.bankingapplication.screens.displayallaccounts;

import java.util.List;

import com.visithraa23.bankingapplication.dto.Account;
import com.visithraa23.bankingapplication.repository.BankRepository;

public class DisplayAllAccountViewModel {
	private DisplayAllAccountView displayAllAccountView;
	private BankRepository bankRepository;

	public DisplayAllAccountViewModel(DisplayAllAccountView view) {
		displayAllAccountView = view;
		bankRepository = BankRepository.getInstance();
	}

	public List<Account> displayAllAccount() {

		return bankRepository.displayAllAccount();
	}

}
