package com.cg.money_tracker.dto;

import lombok.Data;

@Data 
public class TransactionResponse<T> {
    private String message;
    private T data;
    
    public TransactionResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    
}
