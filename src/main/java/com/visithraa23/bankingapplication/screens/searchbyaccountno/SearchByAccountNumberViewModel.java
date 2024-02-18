package com.visithraa23.bankingapplication.screens.searchbyaccountno;

import java.util.List;

import com.visithraa23.bankingapplication.dto.Account;
import com.visithraa23.bankingapplication.repository.BankRepository;

public class SearchByAccountNumberViewModel {
	private SearchByAccountNumberView searchView;
	private BankRepository bankRepository;

	public SearchByAccountNumberViewModel(SearchByAccountNumberView view) {
		searchView = view;
		bankRepository = BankRepository.getInstance();
	}

	public List searchByAccountNo(String accountNumber) {
		List<Account> list = bankRepository.searchByAccount(accountNumber);
		return list.isEmpty() ? null : list;
	}

}
