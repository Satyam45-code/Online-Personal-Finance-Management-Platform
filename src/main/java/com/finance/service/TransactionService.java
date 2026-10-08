package com.finance.service;

import com.finance.dao.TransactionDAO;
import com.finance.model.Transaction;

public class TransactionService {
    private final TransactionDAO dao = new TransactionDAO();

    public void save(Transaction transaction) throws Exception {
        dao.save(transaction);
    }
}
