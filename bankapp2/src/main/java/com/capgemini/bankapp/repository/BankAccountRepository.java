package com.capgemini.bankapp.repository;

import java.util.List;

import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.exception.AccountNotFoundException;

public interface BankAccountRepository {

	public double getBalance(long accountId) throws AccountNotFoundException;

	public boolean updateBalance(long accountId, double newBalance);

	public boolean addBankAccount(BankAccount account);
	
	public boolean deleteBankAccount(long accountId);

	public BankAccount findBankAccountById(long accountId);

	public List<BankAccount> findAllBankAccounts();

	public BankAccount updateBankAccount(BankAccount account);

}