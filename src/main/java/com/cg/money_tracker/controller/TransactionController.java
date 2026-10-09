package com.cg.money_tracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.money_tracker.dto.TransactionResponse;
import com.cg.money_tracker.entity.Transaction;
import com.cg.money_tracker.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {
    private TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/transaction")
    public TransactionResponse<Transaction> save(@RequestBody Transaction t){
        return service.saveTransaction(t);
    }
}
