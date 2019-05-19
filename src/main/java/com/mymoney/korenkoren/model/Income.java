package com.mymoney.korenkoren.model;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Income {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Please fill your income")
	private Integer myIncome;
	
	@NotNull(message = "Total costs cannot be empty")
	private Integer totalCosts;
	
	@NotNull(message = "Storage cannot be empty")
	private Integer storage;
	
	@NotNull(message = "Relax cannot be empty")
	private Integer relax;
	
	@Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMyIncome() {
		return myIncome;
	}
	public void setMyIncome(Integer myIncome) {
		this.myIncome = myIncome;
	}
	public Integer getTotalCosts() {
		return totalCosts;
	}
	public void setTotalCosts(Integer totalCosts) {
		this.totalCosts = totalCosts;
	}
	public Integer getStorage() {
		return storage;
	}
	public void setStorage(Integer storage) {
		this.storage = storage;
	}
	public Integer getRelax() {
		return relax;
	}
	public void setRelax(Integer relax) {
		this.relax = relax;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
}
