package com.cg.money_tracker.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.money_tracker.dto.TransactionResponse;
import com.cg.money_tracker.entity.Transaction;
import com.cg.money_tracker.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public TransactionResponse<Transaction> saveTransaction(Transaction t) {
        Transaction newT = repository.save(t);
        if (newT == null) {
            return new TransactionResponse<>("failed to save transaction", null);
        }
        return new TransactionResponse<>("saved succesfully", newT);
    }

    public TransactionResponse<Transaction> getTransaction(int id) {
        Optional<Transaction> t = repository.findById(id);
        if (t.isEmpty()) {
            return new TransactionResponse<>("transaction not found", null);
        }
        return new TransactionResponse<>("transaction found succesfully", t.get());
    }




}
