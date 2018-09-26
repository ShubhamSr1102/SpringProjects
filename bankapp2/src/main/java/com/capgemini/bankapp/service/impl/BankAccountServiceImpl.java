package com.capgemini.bankapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.InsufficientAccountBalanceException;
import com.capgemini.bankapp.exception.NegativeAmountException;
import com.capgemini.bankapp.repository.BankAccountRepository;
import com.capgemini.bankapp.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public double getBalance(long accountId) throws AccountNotFoundException {
		return bankAccountRepository.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) throws AccountNotFoundException {
		double accountBalance = bankAccountRepository.getBalance(accountId);
		bankAccountRepository.updateBalance(accountId, accountBalance - amount);
		return accountBalance - amount;
	}

	@Override
	public double deposit(long accountId, double amount) throws AccountNotFoundException {
		double accountBalance = bankAccountRepository.getBalance(accountId);
		bankAccountRepository.updateBalance(accountId, accountBalance + amount);
		return accountBalance + amount;
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount)
			throws InsufficientAccountBalanceException, NegativeAmountException, AccountNotFoundException {
		double accountBalanceFrom = bankAccountRepository.getBalance(fromAcc);
		
		if (accountBalanceFrom < amount) 
			throw new InsufficientAccountBalanceException("There isn't sufficient balance in your account!");
		else if (amount < 0)
			throw new NegativeAmountException("The amount cannot be negative!");
		else {
			double balance = withdraw(fromAcc, amount);
			if (balance != -1)
				if(deposit(toAcc,amount) == -1) {
				deposit(toAcc, amount);
			return false;
		}
			return true;

		}
	}

	@Override
	public boolean addBankAccount(BankAccount account) {
		return bankAccountRepository.addBankAccount(account);
	}

	@Override
	public boolean deleteBankAccount(long accountId) {
		return bankAccountRepository.deleteBankAccount(accountId);
	}

	@Override
	public BankAccount findBankAccountById(long accountId) {
		return bankAccountRepository.findBankAccountById(accountId);
	}

	@Override
	public List<BankAccount> findAllBankAccounts() {
		return bankAccountRepository.findAllBankAccounts();
	}

	@Override
	public BankAccount updateBankAccount(BankAccount account) {
		return bankAccountRepository.updateBankAccount(account);
	}

}
