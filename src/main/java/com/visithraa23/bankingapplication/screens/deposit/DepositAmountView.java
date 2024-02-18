package com.visithraa23.bankingapplication.screens.deposit;

import java.util.Scanner;

public class DepositAmountView {
	private DepositAmountViewModel depositViewModel;

	public DepositAmountView() {
		depositViewModel = new DepositAmountViewModel(this);
	}

	public void depositAmount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account Number : ");
		String accountNumber = sc.next();
		System.out.println("Enter the Amount to Deposit : ");
		double amount = sc.nextDouble();
		depositViewModel.depositAmount(accountNumber, amount);
	}

	public void printOutput(String message) {
		System.out.println(message);
	}

}
