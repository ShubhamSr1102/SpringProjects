package com.capgemini.bankapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;

@Configuration

public class Application {

	public static void main(String[] args) throws LowBalanceException {
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BankAccountController bankAccountController = context.getBean("bankAccountController",
				BankAccountController.class);
		try {
			System.out.println(bankAccountController.getBalance(12));
			System.out.println(bankAccountController.deposit(15, 5000));
			System.out.println(bankAccountController.withdraw(12, 3000));
			System.out.println(bankAccountController.getBalance(15));
			// System.out.println(bankAccountController.);
		} catch (AccountNotFoundException | LowBalanceException e) {
			System.out.println(e.getMessage());

		}

	}

}
