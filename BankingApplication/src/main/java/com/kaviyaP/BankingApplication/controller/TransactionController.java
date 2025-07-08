package com.kaviyaP.BankingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kaviyaP.BankingApplication.model.Transaction;
import com.kaviyaP.BankingApplication.repository.TransactionRepository;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "*")  // Allow frontend to call this API
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/account/{accountId}")
    public List<Transaction> getTransactionsByAccount(@PathVariable Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
