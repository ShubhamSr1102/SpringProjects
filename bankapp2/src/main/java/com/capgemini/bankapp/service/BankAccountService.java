package com.capgemini.bankapp.service;

import java.util.List;

import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.InsufficientAccountBalanceException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.exception.NegativeAmountException;

public interface BankAccountService {

	public double getBalance(long accountId) throws AccountNotFoundException;

	public double withdraw(long accountId, double amount) throws LowBalanceException, AccountNotFoundException;

	public double deposit(long accountId, double amount) throws AccountNotFoundException;

	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException,
			InsufficientAccountBalanceException, NegativeAmountException, AccountNotFoundException;

	public boolean addBankAccount(BankAccount account);

	public boolean deleteBankAccount(long accountId);

	public BankAccount findBankAccountById(long accountId);

	public List<BankAccount> findAllBankAccounts();

	public BankAccount updateBankAccount(BankAccount account);
}
