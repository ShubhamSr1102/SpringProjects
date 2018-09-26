package com.capgemini.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.InsufficientAccountBalanceException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.exception.NegativeAmountException;
import com.capgemini.bankapp.service.BankAccountService;

@Controller
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;

	public double getBalance(long accountId) throws AccountNotFoundException {
		return bankAccountService.getBalance(accountId);

	}

	public double withdraw(long accountId, double amount) throws LowBalanceException, AccountNotFoundException {
		return bankAccountService.withdraw(accountId, amount);
	}

	public double deposit(long accountId, double amount) throws AccountNotFoundException {
		return bankAccountService.deposit(accountId, amount);
	}

	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException,
			InsufficientAccountBalanceException, NegativeAmountException, AccountNotFoundException {
		return bankAccountService.fundTransfer(fromAccount, toAccount, amount);
	}

	public boolean addBankAccount(BankAccount account) {
		return bankAccountService.addBankAccount(account);
	}

	public boolean deleteBankAccount(long accountId) {
		return bankAccountService.deleteBankAccount(accountId);
	}

	public BankAccount findBankAccountById(long accountId) {
		return bankAccountService.findBankAccountById(accountId);
	}

	public List<BankAccount> findAllBankAccounts() {
		return bankAccountService.findAllBankAccounts();
	}

	public BankAccount updateBankAccount(BankAccount account) {
		return bankAccountService.updateBankAccount(account);
	}
}
