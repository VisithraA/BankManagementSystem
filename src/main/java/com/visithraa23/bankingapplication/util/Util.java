package com.visithraa23.bankingapplication.util;

public class Util {

	public static boolean validatePhoneNumber(String number) {
		String regex = "^(?:\\+\\d{1,3})?\\d{10}$";
		if (number.matches(regex))
			return true;
		return false;
	}

	public static boolean validateInitialAmount(double amount) {
		if (amount >= 100)
			return true;
		return false;
	}

	public static boolean checkUser(String userName, String password) {
		String loginId = "Visithraa23";
		String pwd = "12345";
		if (userName.equals(loginId) &&  password.equals(pwd))
			return true;
		return false;
	}
}
