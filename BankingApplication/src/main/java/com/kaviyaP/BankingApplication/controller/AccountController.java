package com.kaviyaP.BankingApplication.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kaviyaP.BankingApplication.model.Account;
import com.kaviyaP.BankingApplication.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }


    @PostMapping("/create")
    public Account create(@RequestBody Map<String, Object> payload) {
        Long userId = Long.valueOf(payload.get("userId").toString());
        String type = payload.get("type").toString();
        Double balance = Double.valueOf(payload.get("balance").toString());
        return accountService.createAccount(userId, type, balance);
    }


    @PostMapping("/deposit")
    public Account deposit(@RequestParam Long accountId, @RequestParam Double amount) {
        return accountService.deposit(accountId, amount);
    }

    @PostMapping("/withdraw")
    public Account withdraw(@RequestParam Long accountId, @RequestParam Double amount) {
        return accountService.withdraw(accountId, amount);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long fromAccount,
                           @RequestParam Long toAccount,
                           @RequestParam Double amount) {
        accountService.transfer(fromAccount, toAccount, amount);
        return "Transferred successfully";
    }
}