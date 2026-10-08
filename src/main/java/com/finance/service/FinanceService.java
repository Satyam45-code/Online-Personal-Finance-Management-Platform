package com.finance.service;

import com.finance.exception.InvalidAmountException;
import com.finance.interfaces.FinanceOperations;
import com.finance.model.*;

public class FinanceService implements FinanceOperations {
    private final TransactionService transactionService = new TransactionService();

    @Override
    public void addTransaction(Transaction transaction) throws Exception {
        if (transaction.getAmount() <= 0)
            throw new InvalidAmountException("Amount must be greater than zero.");
        transactionService.save(transaction);
    }

    @Override
    public void addBudget(Budget budget) throws Exception {
        if (budget.getAmount() <= 0)
            throw new InvalidAmountException("Budget must be greater than zero.");
        new com.finance.dao.BudgetDAO().save(budget);
    }

    @Override
    public void addGoal(Goal goal) throws Exception {
        if (goal.getTargetAmount() <= 0)
            throw new InvalidAmountException("Target amount must be greater than zero.");
        new com.finance.dao.GoalDAO().save(goal);
    }
}
