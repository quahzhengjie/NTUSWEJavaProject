package com.example.simplecrm.service;

import com.example.simplecrm.model.ExpensesClaim;
import com.example.simplecrm.model.ExpenseStatus;
import com.example.simplecrm.model.Employee;
import com.example.simplecrm.repository.ExpensesClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesClaimServiceImpl implements ExpensesClaimService {

  private final ExpensesClaimRepository expensesClaimRepository;

  @Autowired
  public ExpensesClaimServiceImpl(ExpensesClaimRepository expensesClaimRepository) {
    this.expensesClaimRepository = expensesClaimRepository;
  }

  @Override
  public List<ExpensesClaim> getAllExpenses() {
    // Retrieve all expenses from the repository
    return expensesClaimRepository.findAll();
  }

  @Override
  public Optional<ExpensesClaim> getExpenseById(Long expenseId) {
    // Retrieve an expense by its ID from the repository
    return expensesClaimRepository.findById(expenseId);
  }

  @Override
  public ExpensesClaim createExpense(ExpensesClaim expense) {
    // Save a new expense to the repository
    return expensesClaimRepository.save(expense);
  }

  @Override
  public ExpensesClaim updateExpense(ExpensesClaim expense) {
    // Update an existing expense in the repository
    return expensesClaimRepository.save(expense);
  }

  @Override
  public void deleteExpense(Long expenseId) {
    // Delete an expense from the repository by its ID
    expensesClaimRepository.deleteById(expenseId);
  }

  @Override
  public boolean updateExpenseStatus(Long expenseId, ExpenseStatus newStatus) {
    Optional<ExpensesClaim> optionalExpense = expensesClaimRepository.findById(expenseId);
    if (optionalExpense.isPresent()) {
      ExpensesClaim expense = optionalExpense.get();
      // Update the status of the expense
      expense.setStatus(newStatus);
      // Save the updated expense to the repository
      expensesClaimRepository.save(expense);
      return true;
    }
    // Return false if the expense with the given ID does not exist
    return false;
  }

  @Override
  public boolean updateExpenseApprovals(Long expenseId, Employee supervisor, Employee hod) {
    Optional<ExpensesClaim> optionalExpense = expensesClaimRepository.findById(expenseId);
    if (optionalExpense.isPresent()) {
      ExpensesClaim expense = optionalExpense.get();
      // Set the supervisor and HOD approvals for the expense
      expense.setApprovedBySupervisor(supervisor);
      expense.setApprovedByHod(hod);
      // Save the updated expense to the repository
      expensesClaimRepository.save(expense);
      return true;
    }
    // Return false if the expense with the given ID does not exist
    return false;
  }
}
