package com.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("myservice")
@Transactional
public class MyService {
	
	@Autowired
	private AccountsDAO dao;

	public AccountsDAO getDao() {
		return dao;
	}

	public void setDao(AccountsDAO dao) {
		this.dao = dao;
	}
	
	public void doService(int id , int amount) {
		AccountsDTO dto = dao.findByID(id);
		dto.setAmount(amount);
		dao.update(dto);
	}
	
	public void doInsert(int id , int amount) {
		AccountsDTO dto = new AccountsDTO(id,amount);
		dao.insert(dto);
	}
}