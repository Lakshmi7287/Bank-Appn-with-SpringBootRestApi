package com.rest.service;
import java.util.List;

import com.rest.model.Bank;

public interface BankService {

	public Bank saveBank(Bank bank);

	public Bank getBalanace( Long accountNo);

	public Bank depositBank(Bank bank);

	public Bank withdrawBank(Bank bank);

	public Bank transferBank(Bank bank);

	public Bank closeBank(Bank bank);

	public List< Bank> getAllBank();

	public void deleteBank(Long accountNo);

}
