package com.cg.money_tracker.service;

import java.util.List;
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

    public TransactionResponse<List<Transaction>> getAllTransaction() {
        List<Transaction> t = repository.findAll();
        if (t.isEmpty()) {
            return new TransactionResponse<>("transactions is empty", null);
        }
        return new TransactionResponse<>("transactions found succesfully", t);
    }

    public TransactionResponse<Transaction> updateTransaction(Transaction t) {
        Optional<Transaction> toUpdateT = repository.findById(t.getId());
        if (toUpdateT.isEmpty()) {
            return new TransactionResponse<>("transaction not found", null);
        }
        
        Transaction updatedT = toUpdateT.get();
        updatedT.setAmount(t.getAmount());
        updatedT.setCategory(t.getCategory());
        updatedT.setDescription(t.getDescription());
        repository.save(updatedT);
        return new TransactionResponse<>("updated succesfully succesfully", updatedT);
    }



}
