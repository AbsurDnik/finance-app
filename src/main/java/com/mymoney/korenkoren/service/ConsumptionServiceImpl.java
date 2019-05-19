package com.mymoney.korenkoren.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymoney.korenkoren.model.Bank;
import com.mymoney.korenkoren.model.Consumption;
import com.mymoney.korenkoren.repository.BankRepository;
import com.mymoney.korenkoren.repository.ConsumptionRepository;

@Service
public class ConsumptionServiceImpl implements ConsumptionService{
	@Autowired
	private ConsumptionRepository consumptionRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Override
	public boolean addConsumption(Consumption consumption,Double limit,String goal) {
		if(consumption.getMyConsumption() < 0 || consumption.getMyConsumption() > limit) {
			return false;
		}
		consumption.setCreationDateTime(LocalDateTime.now());
		updateBank(consumption.getMyConsumption(),goal);
		consumptionRepository.save(consumption);
		return true;
	}

	private void updateBank(Integer myConsumption, String goal) {
		Bank bank = bankRepository.getOne(1);
		if(goal.equals("relax")) {
			bank.setRelaxBank(bank.getRelaxBank()-myConsumption);
		}
		if(goal.equals("totalCosts")) {
			bank.setRelaxBank(bank.getRelaxBank()-myConsumption);
		}
		bankRepository.save(bank);
	}

}
