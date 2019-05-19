package com.mymoney.korenkoren.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Double relaxBank;
	
	private Double totalCostsBank;
	
	private Double storageBank;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getRelaxBank() {
		return relaxBank;
	}

	public void setRelaxBank(Double relaxBank) {
		this.relaxBank = relaxBank;
	}

	public Double getTotalCostsBank() {
		return totalCostsBank;
	}

	public void setTotalCostsBank(Double totalCostsBank) {
		this.totalCostsBank = totalCostsBank;
	}

	public Double getStorageBank() {
		return storageBank;
	}

	public void setStorageBank(Double storageBank) {
		this.storageBank = storageBank;
	}

	
	
}
