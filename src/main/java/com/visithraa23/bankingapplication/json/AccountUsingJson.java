package com.visithraa23.bankingapplication.json;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.visithraa23.bankingapplication.dto.Account;
import com.visithraa23.bankingapplication.repository.BankRepository;

public class AccountUsingJson {
	private static BankRepository bankRepository = BankRepository.getInstance();

	public void addJsonObjects() {
		List<Account> list = readAccountsFromFile("JSONAccount.json");
		if (list != null) {
			for (Account account : list) {
				bankRepository.createAccount(account.getAccountHolderName(), account.getAddress(), account.getPhone(),
						account.getBalance());
				System.out.println(account.getAccountHolderName());
				System.out.println(account.getBalance());
			}
		} else {
			System.out.println("Json Not Added");
		}
	}

	private static List<Account> readAccountsFromFile(String fileName) {
		try (InputStream inputStream = AccountUsingJson.class.getResourceAsStream(fileName);
				InputStreamReader reader = new InputStreamReader(inputStream)) {
			Gson gson = new GsonBuilder()
					.registerTypeAdapter(LocalDateTime.class,
							(JsonDeserializer<LocalDateTime>) (json, typeOfT, context) -> LocalDateTime.parse(
									json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME))
					.create();
			Account[] accounts = gson.fromJson(reader, Account[].class);
			return Arrays.asList(accounts);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
