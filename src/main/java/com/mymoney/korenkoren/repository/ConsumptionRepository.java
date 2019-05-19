package com.mymoney.korenkoren.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymoney.korenkoren.model.Consumption;

public interface ConsumptionRepository extends JpaRepository<Consumption,Integer> {

}
