package com.finance.service;

public class BalanceManager {
    private double balance;

    public synchronized void updateBalance(double amount) {
        balance += amount;
    }

    public synchronized double getBalance() {
        return balance;
    }
}
