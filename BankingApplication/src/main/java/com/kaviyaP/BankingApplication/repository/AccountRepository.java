package com.kaviyaP.BankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaviyaP.BankingApplication.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
}