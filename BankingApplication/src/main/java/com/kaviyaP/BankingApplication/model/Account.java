package com.kaviyaP.BankingApplication.model;
import jakarta.persistence.*;
import lombok.*;

@Entity

public class Account {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String accountType;
	    private Double balance;
	    
	    @ManyToOne
	    private User user;
	    
	    public Account() {
	    }


		public Account(Long id, String accountType, Double balance, User user) {
			
			this.id = id;
			this.accountType = accountType;
			this.balance = balance;
			this.user = user;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAccountType() {
			return accountType;
		}

		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}

		public Double getBalance() {
			return balance;
		}

		public void setBalance(Double balance) {
			this.balance = balance;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	    

}
