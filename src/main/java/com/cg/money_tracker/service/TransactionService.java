package com.cg.money_tracker.service;

import org.springframework.stereotype.Service;

import com.cg.money_tracker.repository.TransactionRepository;

@Service 
public class TransactionService {

    private final TransactionRepository repository;

    TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }
}
