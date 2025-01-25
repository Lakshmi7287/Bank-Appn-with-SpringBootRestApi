package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.Bank;
import com.rest.repo.BankRepo;

@Service
public class BankServiceImp implements BankService {
	@Autowired
	private BankRepo repo;
	
	@Override
	public Bank saveBank(Bank bank) {
		
        return repo.save(bank);
    }
	@Override
	public Bank getBalanace( Long accountNo) {

		Bank a=repo.findById(accountNo).get();
	
		return a;
	}

	@Override
	public Bank depositBank(Bank bank) {
		Long ano=bank.getAccountNo();
		   Double depbal=   bank.getBalance();  //deposit balance (User will Enter)
		  Bank a= repo.findById( ano).get();
		 Double actbal= a.getBalance();          //actual balance
		 Double adbal=actbal+depbal;           //after deposit total balance is
		
		 a.setBalance(adbal);
		 
		return repo.save(a);
	}

	@Override
	public Bank withdrawBank(Bank bank) {
		Long ano=bank.getAccountNo();
		   Double witbal=   bank.getBalance();  //withdraw balance (User will Enter)
		  Bank a= repo.findById(ano).get();
		 Double actbal= a.getBalance();          //actual balance
		 Double awbal=actbal-witbal;           //after withdraw total balance is
		
		 a.setBalance(awbal);
		 repo.save(a);
		return bank;
	}

	@Override
	public Bank transferBank(Bank bank) {
		Long sano=bank.getAccountNo();
		Long tano=bank.getTransferAccountNo();
		Double tbal=bank.getBalance();        //transfered balance
		
		Bank sa=repo.findById(sano).get();       //source account (amount deducted account)
		Double sabal=sa.getBalance();
		      Double atbal=sabal-tbal;       //after transfer balance to the source account
	
		      Bank ta=repo.findById(tano).get();	 //transfer account (amount received  account)  
		      Double tabal=ta.getBalance();
		      Double arbal=tabal+tbal;            //after received balance to transfer account
		      
		      sa.setBalance(atbal);
		      ta.setBalance(arbal);
		      repo.save(sa);
		      repo.save(ta);
		   return bank;
	}

	@Override
	public Bank closeBank(Bank bank) {
		Long ano=bank.getAccountNo();
		Bank a=repo.findById(ano).get();
		String status=a.getStatus();
		status="InActive";
		
		a.setStatus(status);
		repo.save(a);
		return bank;
	}

	@Override
	public List<Bank> getAllBank() {
		List<Bank> getAll=(List<Bank>) repo.findAll();
		return getAll;
	}

	@Override
	public void deleteBank(Long accountNo) {
		repo.deleteById(accountNo);
		
	}

	
}
