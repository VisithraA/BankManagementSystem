package com.visithraa23.bankingapplication.screens.withdraw;

import java.util.Scanner;

public class WithdrawAmountView {
	private WithdrawAmountViewModel withdrawViewModel;

	public WithdrawAmountView() {
		withdrawViewModel = new WithdrawAmountViewModel(this);
	}

	public void withdrawlAmount() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Account Number : ");
		String accountNumber = sc.next();
		System.out.println("Enter the Withdrawl Amount : ");
		double amount = sc.nextDouble();
		withdrawViewModel.withdrawlAmount(accountNumber, amount);
	}

	public void printOutput(String message) {
		System.out.println(message);
	}

}
