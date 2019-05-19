package com.mymoney.korenkoren.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mymoney.korenkoren.model.Bank;
import com.mymoney.korenkoren.model.Consumption;
import com.mymoney.korenkoren.repository.BankRepository;
import com.mymoney.korenkoren.repository.ConsumptionRepository;
import com.mymoney.korenkoren.service.ConsumptionService;
import com.mymoney.korenkoren.service.IncomeService;

@Controller
@RequestMapping("/my-consumption")
public class ConsumptionController {
	//@Autowired
	//private IncomeService incomeService;
	@Autowired
	private ConsumptionRepository consumptionRepository;
	
	@Autowired
	private ConsumptionService consumptionService;
	
	@Autowired
	private IncomeService incomeService;
	
	@Autowired
	private BankRepository bankRepository;
	
	@GetMapping//список расходов
	public String getMyConsumptionPage(Model model) {
		model.addAttribute("currentPage","consumptionPage");
		model.addAttribute("сonsumptionList",consumptionRepository.findAll());
		return "myConsumption";
	}
	
	
	
	
	@GetMapping("/add-consumption")
	public String addNoTypeConsumption(Model model) {
		model.addAttribute("currentPage","consumptionPage");
		model.addAttribute("noType",true);
		return "addConsumption";
	}
	
	
	@GetMapping("/add-consumption/total-costs")
	public String totalCostsConsumption(Model model) {
		model.addAttribute("currentPage","consumptionPage");
		model.addAttribute("noType",false);
		Bank bank = bankRepository.getOne(1);
		model.addAttribute("limit",bank.getTotalCostsBank());
		model.addAttribute("consumptionType","общие затраты");
		return "addConsumption";
	}
	@PostMapping("/add-consumption/total-costs")
	public String addTotalCostsConsumption(
			@Valid Consumption consumption,
			BindingResult bindingResult,
			Model model) {
		Bank bank = bankRepository.getOne(1);
		Double limit = bank.getTotalCostsBank();
		model.addAttribute("currentPage","consumptionPage");
		
		model.addAttribute("noType",false);
		model.addAttribute("limit",limit);
		model.addAttribute("consumptionType","общие затраты");
		
		if(bindingResult.hasErrors()) {
			Map<String,String> errorsMap = ControllerUtils.getErrors(bindingResult);
			model.mergeAttributes(errorsMap);
		}else {
			consumption.setCategory("Общие затраты");
			if(!consumptionService.addConsumption(consumption,limit,"totalCosts")) {
				model.addAttribute("dataError","Please input correct data");
				return "addConsumption";
			}
			return "redirect:/my-consumption";
		}	
		return "addConsumption";
	}
	
	
	
	
	
	
	@GetMapping("/add-consumption/relax")
	public String relaxConsumption(Model model) {
		model.addAttribute("currentPage","consumptionPage");
		model.addAttribute("noType",false);
		Bank bank = bankRepository.getOne(1);
		model.addAttribute("limit",bank.getRelaxBank());
		model.addAttribute("consumptionType","отдых");
		return "addConsumption";
	}
	@PostMapping("/add-consumption/relax")
	public String addRelaxConsumption(
			@Valid Consumption consumption,
			BindingResult bindingResult,
			Model model) {
		Bank bank = bankRepository.getOne(1);
		Double limit = bank.getRelaxBank();
		model.addAttribute("currentPage","consumptionPage");
		
		model.addAttribute("noType",false);
		model.addAttribute("limit",limit);
		model.addAttribute("consumptionType","отдых");
		
		if(bindingResult.hasErrors()) {
			Map<String,String> errorsMap = ControllerUtils.getErrors(bindingResult);
			model.mergeAttributes(errorsMap);
		}else {
			consumption.setCategory("Отдых");
			if(!consumptionService.addConsumption(consumption,limit,"relax")) {
				model.addAttribute("dataError","Please input correct data");
				return "addConsumption";
			}
			return "redirect:/my-consumption";
		}	
		return "addConsumption";
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/more-info/{id}")
	public String getMoreInfo(@PathVariable(value = "id") Consumption consumption,
			Model model) {
		model.addAttribute("currentPage","consumptionPage");
		model.addAttribute("currentConsumption",consumption);
		return "details";
	}
	@GetMapping("/{id}")
	public String deleteConsumption(@PathVariable Integer id) {
		consumptionRepository.deleteById(id);
		return "redirect:/my-consumption";
	}
	@GetMapping("/delete-history")
	public String deleteConsumptionHistory() {
		consumptionRepository.deleteAll();
		return "redirect:/my-consumption";
	}




}
