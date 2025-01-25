package com.rest.repo;

import org.springframework.data.repository.CrudRepository;

import com.rest.model.Bank;

public interface BankRepo extends CrudRepository<Bank, Long> {

}
