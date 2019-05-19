package com.mymoney.korenkoren.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mymoney.korenkoren.model.Bank;
import com.mymoney.korenkoren.repository.BankRepository;

@Controller
public class MainController {
	
	@Autowired
	private BankRepository bankRepository;
	
	@GetMapping("/")
	public String getMainPage(Model model) {
		model.addAttribute("currentPage","mainPage");
		Bank bank = bankRepository.getOne(1);
		Double total = bank.getTotalCostsBank()+bank.getRelaxBank()+bank.getStorageBank();
		model.addAttribute("totalCostsBank",bank.getTotalCostsBank());
		model.addAttribute("relaxBank", bank.getRelaxBank());
		model.addAttribute("storageBank", bank.getStorageBank());
		model.addAttribute("incomeBank", total);
		return "main";
	}
	@GetMapping("/edit")
	public String getEditPage(Model model) {
		model.addAttribute("currentPage","mainPage");
		model.addAttribute("noAct",true);
		return "editBank";
	}
	@GetMapping("/edit/replenish")
	public String replenishPage(Model model) {
		model.addAttribute("currentPage","mainPage");
		model.addAttribute("noAct",false);
		model.addAttribute("button","Пополнить баланс");
		Bank bank = bankRepository.getOne(1);
		
		model.addAttribute("totalCostsBank",bank.getTotalCostsBank());
		model.addAttribute("relaxBank", bank.getRelaxBank());
		model.addAttribute("storageBank", bank.getStorageBank());
		return "editBank";
	}
	@PostMapping("/edit/replenish")
	public String postReplenishPage(
			@RequestParam Integer totalCosts,
			@RequestParam Integer storage,
			@RequestParam Integer relax) {
		Bank bank = bankRepository.getOne(1);
		bank.setRelaxBank(bank.getRelaxBank() + relax);
		bank.setStorageBank(bank.getStorageBank() + storage);
		bank.setTotalCostsBank(bank.getTotalCostsBank() + totalCosts);
		bankRepository.save(bank);
		return "redirect:/";
	}
	
	
	
	
	@GetMapping("/edit/write-off")
	public String writeOffPage(Model model) {
		model.addAttribute("currentPage","mainPage");
		model.addAttribute("noAct",false);
		model.addAttribute("button","Списать со счета");
		
		Bank bank = bankRepository.getOne(1);
		
		model.addAttribute("totalCostsBank",bank.getTotalCostsBank());
		model.addAttribute("relaxBank", bank.getRelaxBank());
		model.addAttribute("storageBank", bank.getStorageBank());
		return "editBank";
	}
	@PostMapping("/edit/write-off")
	public String postWriteOffPage(
			@RequestParam Integer totalCosts,
			@RequestParam Integer storage,
			@RequestParam Integer relax) {
		Bank bank = bankRepository.getOne(1);
		bank.setRelaxBank(bank.getRelaxBank() - relax);
		bank.setStorageBank(bank.getStorageBank() - storage);
		bank.setTotalCostsBank(bank.getTotalCostsBank() - totalCosts);
		bankRepository.save(bank);
		return "redirect:/";
	}
}
