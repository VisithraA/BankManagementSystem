package com.visithraa23.bankingapplication.screens.manageaccount.addaccount;

import java.util.Scanner;

import com.visithraa23.bankingapplication.util.Util;

public class AddAccountView {
	private AddAccountViewModel addAccountViewModel;

	public AddAccountView() {
		addAccountViewModel = new AddAccountViewModel(this);
	}

	public void createAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Account Holder's Name : ");
		String name = sc.nextLine();
		System.out.print("Enter the Account Holder's Address : ");
		String address = sc.nextLine();
		System.out.print("Enter the Phone Number : ");
		String phone = sc.next();
		if (Util.validatePhoneNumber(phone)) {
			System.out.print("Enter the Initial Amount : ");
			double initialAmount = sc.nextDouble();
			if (Util.validateInitialAmount(initialAmount)) {
				addAccountViewModel.createAccount(name, address, phone, initialAmount);
			} else {
				System.out.println("Minimum Amount Must be 100 Rupees..\n");
			}

		} else {
			System.out.println("Enter Valid Phone Number...\n");
		}

	}

	public void printOutput(String string) {
		System.out.println(string);
	}

}
