package com.finance.interfaces;

import com.finance.model.Transaction;
import com.finance.model.Budget;
import com.finance.model.Goal;

public interface FinanceOperations {
    void addTransaction(Transaction transaction) throws Exception;
    void addBudget(Budget budget) throws Exception;
    void addGoal(Goal goal) throws Exception;
}
