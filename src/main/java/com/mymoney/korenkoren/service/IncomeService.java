package com.mymoney.korenkoren.service;

import com.mymoney.korenkoren.model.Income;

public interface IncomeService {

	boolean addIncome(Income income);

	Double findTotalCostsBank();

	Double findRelaxBank();

	Double findStorageBank();

	Integer findIncomeBank();

}