package com.visithraa23.bankingapplication.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.visithraa23.bankingapplication.dto.Account;
import com.visithraa23.bankingapplication.dto.Transaction;

public class BankRepository {
	private static BankRepository bankRepository;
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction et;
	private static String accNo = "213554320";

	public BankRepository() {
		emf = Persistence.createEntityManagerFactory("dev");
		em = emf.createEntityManager();
		et = em.getTransaction();
	}

	public static BankRepository getInstance() {
		if (bankRepository == null)
			bankRepository = new BankRepository();
		return bankRepository;
	}

	public Account createAccount(String name, String address, String phone, double initialAmount) {
		if (accountNumber(phone, name) == null) {

			Account account = new Account();
			account.setAccountHolderName(name);
			long lastAccNo = findLastAccNo();
			if (lastAccNo == 0) {
				account.setAccountNumber(accNo);
			} else {
				account.setAccountNumber(Long.toString(lastAccNo + 1));
			}
			account.setAddress(address);
			account.setBalance(initialAmount);
			account.setPhone(phone);
			account.setOpenDate(LocalDateTime.now());

			Transaction transaction = new Transaction();
			transaction.setDeposit(initialAmount);
			transaction.setTransactionDate(LocalDateTime.now());
			transaction.setAccount(account);

			try {
				et.begin();
				em.persist(transaction);
				em.persist(account);
				et.commit();
			} catch (Exception e) {
				if (et.isActive())
					et.rollback();
			}

			return accountNumber(phone, name);
		} else {
			return null;
		}

	}

	private long findLastAccNo() {
		Query query = em.createQuery("select MAX(acc.accountNumber) from Account acc");
		Object result = query.getSingleResult();
		Long lastAccNo = null;
		if (result != null)
			lastAccNo = Long.valueOf(result.toString());
		return lastAccNo==null?0:lastAccNo;
	}

	private Account accountNumber(String phone, String name) {
		Query query = em.createQuery("Select acc from Account acc where acc.phone=?1 AND acc.accountHolderName=?2");
		query.setParameter(1, phone);
		query.setParameter(2, name);
		List<Account> list = query.getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

	public List<Account> searchByAccount(String accountNumber) {
		Query query = em.createQuery("select acc from Account acc where accountNumber LIKE :partialAcc");
		query.setParameter("partialAcc", "%" + accountNumber + "%");
		List<Account> list = query.getResultList();
		return list.isEmpty() ? null : list;
	}

	public List<Account> displayAllAccount() {
		Query query = em.createQuery("Select acc from Account acc");
		List<Account> list = query.getResultList();
		return list.isEmpty() ? null : list;
	}

	public Account checkAccountNumber(String accountNumber) {
		try {
			Query query = em.createQuery("Select acc from Account acc where accountNumber=?1");
			query.setParameter(1, accountNumber);
			Account account = (Account) query.getSingleResult();
			return account;
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean depositAmount(double amount, Account account) {
		if (account != null) {
			try {
				et.begin();
				double currentBalance = account.getBalance();
				double newBalance = currentBalance + amount;
				account.setBalance(newBalance);
				em.merge(account);

				Transaction transaction = new Transaction();
				transaction.setDeposit(amount);
				transaction.setTransactionDate(LocalDateTime.now());
				transaction.setAccount(account);
				em.persist(transaction);
				et.commit();
			} catch (Exception e) {
				if (et.isActive()) {
					et.rollback();
				}
				return false;
			}
		}
		return true;
	}

	public boolean withdrawlAmount(double amount, Account account) {
		if (account != null) {
			try {
				et.begin();
				double currentBalance = account.getBalance();

				double newBalance = currentBalance - amount;
				account.setBalance(newBalance);
				em.merge(account);

				Transaction transaction = new Transaction();
				transaction.setWithdrawl(amount);
				transaction.setTransactionDate(LocalDateTime.now());
				transaction.setAccount(account);
				em.persist(transaction);
				et.commit();
				return true;
			} catch (Exception e) {
				if (et.isActive()) {
					et.rollback();
				}

			}
		}
		return false;
	}

}
