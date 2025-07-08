package com.kaviyaP.BankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaviyaP.BankingApplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
