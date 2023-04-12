package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankException.InsufficientBalanceException;

@Service("tss")
public class Transaction {
	
	@Autowired
	BankingService bss;
	
	public void doTransaction(int id1, int id2 , int amount) throws InsufficientBalanceException {
		bss.credit(id1, amount);
		bss.debit(id2, amount);
	}
}