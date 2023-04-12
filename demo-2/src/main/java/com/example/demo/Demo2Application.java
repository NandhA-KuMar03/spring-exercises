package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.BankException.InsufficientBalanceException;
import com.model.Transaction;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) throws InsufficientBalanceException {

		ApplicationContext ctx =  SpringApplication.run(Demo2Application.class, args);

		Transaction tra = ctx.getBean("tss" , Transaction.class);
		
		tra.doTransaction(4, 2, 500);

	}

}
