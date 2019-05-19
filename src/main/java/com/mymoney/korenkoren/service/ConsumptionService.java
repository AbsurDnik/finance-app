package com.mymoney.korenkoren.service;

import com.mymoney.korenkoren.model.Consumption;

public interface ConsumptionService {

	boolean addConsumption(Consumption consumption,Double limit,String goal);

}
