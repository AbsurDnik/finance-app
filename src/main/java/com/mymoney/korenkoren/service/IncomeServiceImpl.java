package com.mymoney.korenkoren.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymoney.korenkoren.model.Bank;
import com.mymoney.korenkoren.model.Income;
import com.mymoney.korenkoren.repository.BankRepository;
import com.mymoney.korenkoren.repository.IncomeRepository;


@Service
public class IncomeServiceImpl implements IncomeService {
	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Override
	public boolean addIncome(Income income) {
		if((
				income.getTotalCosts() + 
				income.getStorage() + 
				income.getRelax()) == 100 && income.getMyIncome() > 0) {
			
			//добавить дату добавление дохода
			income.setCreationDate(LocalDate.now());
			updateBank(income);
			incomeRepository.save(income);
			return true;
		}
		return false;
	}

	private void updateBank(Income income) {
		Bank bank = bankRepository.getOne(1);
		bank.setRelaxBank(bank.getRelaxBank()+(income.getRelax()*income.getMyIncome()/100));
		bank.setStorageBank(bank.getStorageBank()+(income.getStorage()*income.getMyIncome()/100));
		bank.setTotalCostsBank(bank.getTotalCostsBank()+(income.getTotalCosts()*income.getMyIncome()/100));
		bankRepository.save(bank);

		
	}

	/* (non-Javadoc)
	 * @see com.mymoney.korenkoren.service.IncomeService#findTotalCostsBank()
	 */
	@Override
	public Double findTotalCostsBank() {
		Double result = 0.0;
		List<Income> myIncomeList = incomeRepository.findAll();
		for(Income income : myIncomeList)  {
			result+=income.getTotalCosts()*income.getMyIncome()/100.0;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.mymoney.korenkoren.service.IncomeService#findRelaxBank()
	 */
	@Override
	public Double findRelaxBank() {
		Double result = 0.0;
		List<Income> myIncomeList = incomeRepository.findAll();
		for(Income income : myIncomeList)  {
			result+=income.getRelax()*income.getMyIncome()/100.0;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.mymoney.korenkoren.service.IncomeService#findStorageBank()
	 */
	@Override
	public Double findStorageBank() {
		Double result = 0.0;
		List<Income> myIncomeList = incomeRepository.findAll();
		for(Income income : myIncomeList)  {
			result+=income.getStorage()*income.getMyIncome()/100.0;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.mymoney.korenkoren.service.IncomeService#findIncomeBank()
	 */
	@Override
	public Integer findIncomeBank() {
		Integer result = 0;
		List<Income> myIncomeList = incomeRepository.findAll();
		for(Income income : myIncomeList)  {
			result+=income.getMyIncome();
		}
		return result;
	}


}
