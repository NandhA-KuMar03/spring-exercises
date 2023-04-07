package com.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountsDTO {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Id
	private int id;
	private int amount;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: "+this.id+ "Ammount :  "+this.amount;
	}
	public AccountsDTO(int id, int amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	public AccountsDTO() {
		
	}
	
	
	
}
