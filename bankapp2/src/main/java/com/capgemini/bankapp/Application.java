package com.capgemini.bankapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.InsufficientAccountBalanceException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.exception.NegativeAmountException;

@Configuration

public class Application {

	public static void main(String[] args) throws LowBalanceException, InsufficientAccountBalanceException, NegativeAmountException {
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BankAccountController bankAccountController = context.getBean("bankAccountController",
				BankAccountController.class);
	//	BankAccountController bankAccountController = context.getBean(BankAccountController.class);
		try {
		bankAccountController.addBankAccount(new BankAccount(22,"pallavi","SAVINGS",10000));
		bankAccountController.addBankAccount(new BankAccount(15,"naina","SAVINGS",20000));
		System.out.println(bankAccountController.getBalance(22));
		
		bankAccountController.deposit(22, 5000);
		System.out.println(bankAccountController.getBalance(22));
		
		
		System.out.println(bankAccountController.findBankAccountById(22));
		bankAccountController.findAllBankAccounts();
		
		bankAccountController.fundTransfer(22, 15, 1000);
		System.out.println(bankAccountController.getBalance(15));
		
		
		bankAccountController.deleteBankAccount(15);
		
		
	} catch (AccountNotFoundException e) {
		System.out.println(e.getMessage());
	}
	


	}

}
