package com.example.simplecrm.service;

import com.example.simplecrm.model.ExpensesClaim;
import com.example.simplecrm.model.ExpenseStatus;
import com.example.simplecrm.model.Employee;

import java.util.List;
import java.util.Optional;

public interface ExpensesClaimService {

  List<ExpensesClaim> getAllExpenses();

  Optional<ExpensesClaim> getExpenseById(Long expenseId);

  ExpensesClaim createExpense(ExpensesClaim expense);

  ExpensesClaim updateExpense(ExpensesClaim expense);

  void deleteExpense(Long expenseId);

  boolean updateExpenseStatus(Long expenseId, ExpenseStatus newStatus);

  boolean updateExpenseApprovals(Long expenseId, Employee supervisor, Employee hod);
}
