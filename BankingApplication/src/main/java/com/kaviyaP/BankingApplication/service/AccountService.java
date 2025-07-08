package com.kaviyaP.BankingApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaviyaP.BankingApplication.model.Account;
import com.kaviyaP.BankingApplication.model.Transaction;
import com.kaviyaP.BankingApplication.model.User;
import com.kaviyaP.BankingApplication.repository.AccountRepository;
import com.kaviyaP.BankingApplication.repository.TransactionRepository;
import com.kaviyaP.BankingApplication.repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TransactionRepository transactionRepo;

    public Account createAccount(Long userId, String type, Double balance) {
        User user = userRepo.findById(userId).orElseThrow();
        Account acc = new Account(null, type, balance, user);
        return accountRepo.save(acc);
    }

    public Account deposit(Long accountId, Double amount) {
        Account acc = accountRepo.findById(accountId).orElseThrow();
        acc.setBalance(acc.getBalance() + amount);
        accountRepo.save(acc);

        transactionRepo.save(new Transaction(null, "DEPOSIT", amount, LocalDateTime.now(), acc));
        return acc;
    }

    public Account withdraw(Long accountId, Double amount) {
        Account acc = accountRepo.findById(accountId).orElseThrow();
        if (acc.getBalance() < amount) throw new RuntimeException("Insufficient funds");
        acc.setBalance(acc.getBalance() - amount);
        accountRepo.save(acc);

        transactionRepo.save(new Transaction(null, "WITHDRAW", amount, LocalDateTime.now(), acc));
        return acc;
    }
    public Account getAccountById(Long id) {
        return accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }


    public void transfer(Long fromId, Long toId, Double amount) {
        withdraw(fromId, amount);
        deposit(toId, amount);
    }
}
