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

import com.mymoney.korenkoren.model.Income;
import com.mymoney.korenkoren.repository.IncomeRepository;
import com.mymoney.korenkoren.service.IncomeService;

@Controller
@RequestMapping("/my-income")
public class IncomeController {
	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired
	private IncomeService incomeService;
	
	@GetMapping
	public String getMyIncomePage(Model model) {
		model.addAttribute("currentPage","incomePage");
		model.addAttribute("incomeList",incomeRepository.findAll());
		return "myIncome";
	}
	
	@PostMapping
	public String addIncome(
			@Valid Income income,
			BindingResult bindingResult,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			Map<String,String> errorsMap = ControllerUtils.getErrors(bindingResult);
			model.mergeAttributes(errorsMap);
			model.addAttribute("incomeList",incomeRepository.findAll());
			model.addAttribute("newIncome",income);
			model.addAttribute("currentPage","incomePage");
			
		}else {
			if(!incomeService.addIncome(income)) {
				model.addAttribute("incomeList",incomeRepository.findAll());
				model.addAttribute("dataError","Please input correct data");
				model.addAttribute("newIncome",income);
				model.addAttribute("currentPage","incomePage");
				return "myIncome";
			}
			return "redirect:/my-income";
		}
		
		return "myIncome";
		
		
	}
	
	@GetMapping("/{id}")
	public String deleteIncome(@PathVariable Integer id) {
		incomeRepository.deleteById(id);
		return "redirect:/my-income";
	}
	@GetMapping("/delete-history")
	public String deleteIncomeHistory() {
		incomeRepository.deleteAll();
		return "redirect:/my-income";
	}
}
