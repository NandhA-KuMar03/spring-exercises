package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.BankException.InsufficientBalanceException;

@Service("bss")
@Transactional
public class BankingService {
	
	@Autowired
	private AccountsDAO dao;
	public AccountsDAO getDao() {
		return dao;
	}
	public void setDao(AccountsDAO dao) {
		this.dao = dao;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void credit(int id , int amount) {
		AccountsDTO dto = dao.findByID(id);
		dto.setAmount(dto.getAmount()+amount);
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void debit(int id , int amount) throws InsufficientBalanceException {
		AccountsDTO dto = dao.findByID(id);
		if(amount > dto.getAmount()) {
			throw new InsufficientBalanceException("Kassu ilaaa broo");
		}
		dto.setAmount(dto.getAmount()-amount);
		dao.update(dto);
	}
}
