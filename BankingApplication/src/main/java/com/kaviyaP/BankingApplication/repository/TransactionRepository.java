package com.kaviyaP.BankingApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaviyaP.BankingApplication.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findByAccountId(Long accountId);
	
}
