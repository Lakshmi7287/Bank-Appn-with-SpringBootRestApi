package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Bank;
import com.rest.service.BankService;

@RestController
@CrossOrigin("*")
public class BankController {

	@Autowired
	private BankService service;
	
	@PostMapping("/save")
	public String Save(@RequestBody Bank bank) {
		if(bank.getPassword().equals(bank.getCpassword())) 
		{
		Bank b= service.saveBank(bank);
			return "Data Inserted Sussfullly........";
		}else {
		return "Data Failed ..........";
	} 
		}
	
	@GetMapping("balance/{accountNo}")
	public Bank Balance(@PathVariable Long accountNo) {
		Bank balance=service.getBalanace( accountNo);
		return balance;	
	}
	
	@PutMapping("deposit/{accountNo}")
	public String Deposit(@RequestBody Bank bank,@PathVariable  Long accountNo) {
		Bank deposit=service.depositBank(bank );
		return" Amount Is Successfully Deposited....";	
	}
	
	@PutMapping("withdraw/{accountNo}")
	public String Withdraw(@RequestBody Bank bank,@PathVariable  Long accountNo) {
		Bank withdraw=service.withdrawBank(bank);
		return" Amount Is Successfully Withdraw....";	
	}
	
	@PutMapping("transfer/{accountNo}")
	public String transfer(@RequestBody Bank bank,@PathVariable  Long accountNo) {
		Bank transfer=service.transferBank(bank);
		return" Amount Is Successfully Transferd....";	
	}
	
	@PutMapping("close/{accountNo}")
	public String close(@RequestBody Bank bank,@PathVariable  Long accountNo) {
		Bank close=service.closeBank(bank);
		
		return "Account Is Successfully Closed .......";	
	}
	
	@GetMapping("/getAll")
	public List<Bank> getAll() {
		List<Bank> GetAll=(List<Bank>) service.getAllBank();
		return GetAll;	
	}
	
	@DeleteMapping("delete/{accountNo}")
	public String Delete(@PathVariable Long accountNo) {
		service.deleteBank(accountNo);
		return "Record Delete Successfully........";	
	}
}
