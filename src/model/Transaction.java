package com.sentinel.fraud-engine;

import java.io.Serializable;

public record Transaction(
    String transactionId, 
    String userId, 
    double amount, 
    long timestamp
) implements Serializable {}