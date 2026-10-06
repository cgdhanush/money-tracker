package com.cg.money_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.money_tracker.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
    
}
