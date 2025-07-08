package com.kaviyaP.BankingApplication.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
@Entity

public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // DEPOSIT, WITHDRAW, TRANSFER
    private Double amount;
    private LocalDateTime timestamp;
    

    
	@ManyToOne
    private Account account;
	
	public Transaction() {
	}

public Transaction(Long id, String type, Double amount, LocalDateTime timestamp, Account account) {
		
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.timestamp = timestamp;
		this.account = account;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
    

}
