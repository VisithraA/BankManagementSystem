package com.visithraa23.bankingapplication.base;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.visithraa23.bankingapplication.json.AccountUsingJson;
import com.visithraa23.bankingapplication.screens.deposit.DepositAmountView;
import com.visithraa23.bankingapplication.screens.displayallaccounts.DisplayAllAccountView;
import com.visithraa23.bankingapplication.screens.manageaccount.addaccount.AddAccountView;
import com.visithraa23.bankingapplication.screens.searchbyaccountno.SearchByAccountNumberView;
import com.visithraa23.bankingapplication.screens.withdraw.WithdrawAmountView;
import com.visithraa23.bankingapplication.util.Util;

public class BaseView {

	public void userInterface() {
//		AccountUsingJson accountUsingJson=new AccountUsingJson();
//		accountUsingJson.addJsonObjects();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the UserName : ");
		String userName = sc.next();
		System.out.println("Enter the Password : ");
		String password = sc.next();
		if (Util.checkUser(userName, password)) {
			boolean condition = true;
			do {
				System.out.println("------------------------------------------------------------");
				System.out.println("|                   WELCOME TO ASVAK BANK                   |");
				System.out.println("|                                                           |");
				System.out.println("|      1. CREATE ACCOUNT                                    |");
				System.out.println("|      2. EDIT ACCOUNT                                      |");
				System.out.println("|      3. DELETE ACCOUNT                                    |");
				System.out.println("|      4. DEPOSIT THE AMOUNT                                |");
				System.out.println("|      5. WITHDRAWL THE AMOUNT                              |");
				System.out.println("|      6. DISPLAY ALL ACCOUNTS                              |");
				System.out.println("|      7. SEARCH BY ACCOUNT NUMBER                          |");
				System.out.println("|      8. EXIT                                              |");
				System.out.println("|                                                           |");
				System.out.println("-------------------------------------------------------------\n\n");

				try {
					System.out.println("Enter the Input...");
					int input = sc.nextInt();
					sc.nextLine();

					switch (input) {
					case 1: {
						AddAccountView addAccountView = new AddAccountView();
						addAccountView.createAccount();
						break;
					}
					case 2: {

						break;
					}
					case 3: {

						break;
					}
					case 4: {
						DepositAmountView depositAmountView = new DepositAmountView();
						depositAmountView.depositAmount();
						break;
					}
					case 5: {
						WithdrawAmountView withdrawAmountView = new WithdrawAmountView();
						withdrawAmountView.withdrawlAmount();
						break;
					}
					case 6: {
						DisplayAllAccountView displayAllAccountView = new DisplayAllAccountView();
						displayAllAccountView.displayAllAccount();
						break;
					}
					case 7: {
						SearchByAccountNumberView searchByAccountNumberView = new SearchByAccountNumberView();
						searchByAccountNumberView.searchByAccountNo();
						break;
					}
					case 8: {
						condition = false;
						break;
					}
					default:
						System.out.println("Enter the Valid Input...");
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Give the Correct Input..");
					sc.nextLine();
				}
			} while (condition);

		} else {
			System.out.println("Login Failed..");
		}
	}

}
