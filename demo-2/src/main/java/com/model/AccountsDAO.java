package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("accountsDAO")
public class AccountsDAO {
	
	@Autowired
	private SessionFactory factory;
	
	//get value
	public AccountsDTO findByID(int acid) {
		Session session=factory.getCurrentSession();
		AccountsDTO dto=session.get(AccountsDTO.class,Integer.valueOf(acid));
		return dto;
	}
	
	//update
	public void update(AccountsDTO dto) {
		Session session  =factory.getCurrentSession();
		session.persist(dto);
	}
	
	public void insert(AccountsDTO dto) {
		Session session = factory.getCurrentSession();
		session.save(dto);	
	}
	
	public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}