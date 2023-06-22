package com.example.simplecrm.controller;

import com.example.simplecrm.model.ExpensesClaim;
import com.example.simplecrm.model.ExpenseStatus;
import com.example.simplecrm.model.Employee;
import com.example.simplecrm.model.UserRole;
import com.example.simplecrm.service.ExpensesClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpensesClaimsController {

  private final ExpensesClaimService expensesClaimService;

  @Autowired
  public ExpensesClaimsController(ExpensesClaimService expensesClaimService) {
    this.expensesClaimService = expensesClaimService;
  }

  //
  /**
   * Creates a new expense.
   *
   * @param expense Expense object to create
   * @return Created expense with HTTP status 201 Created
   */
  @PostMapping
  public ResponseEntity<ExpensesClaim> createExpense(@RequestBody ExpensesClaim expense) {
    ExpensesClaim createdExpense = expensesClaimService.createExpense(expense);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
  }

  /**
   * Retrieves all expenses.
   *
   * @return List of expenses
   */
  @GetMapping
  public ResponseEntity<List<ExpensesClaim>> getAllExpenses() {
    List<ExpensesClaim> expenses = expensesClaimService.getAllExpenses();
    return ResponseEntity.ok(expenses);
  }

  /**
   * Retrieves an expense by ID.
   *
   * @param expenseId ID of the expense to retrieve
   * @return Expense if found, or 404 Not Found status
   */
  @GetMapping("/{expenseId}")
  public ResponseEntity<ExpensesClaim> getExpenseById(@PathVariable Long expenseId) {
    Optional<ExpensesClaim> expense = expensesClaimService.getExpenseById(expenseId);
    if (expense.isPresent()) {
      return ResponseEntity.ok(expense.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  /**
   * Updates an existing expense.
   *
   * @param expenseId ID of the expense to update
   * @param expense   Updated expense object
   * @return Updated expense if found, or 404 Not Found status
   */
  @PutMapping("/{expenseId}")
  public ResponseEntity<ExpensesClaim> updateExpense(@PathVariable Long expenseId, @RequestBody ExpensesClaim expense) {
    Optional<ExpensesClaim> existingExpense = expensesClaimService.getExpenseById(expenseId);
    if (existingExpense.isPresent()) {
      ExpensesClaim updatedExpense = existingExpense.get();
      updatedExpense.setAmount(expense.getAmount());
      updatedExpense.setCategory(expense.getCategory());
      updatedExpense.setApprovedBySupervisor(expense.getApprovedBySupervisor());

      updatedExpense.setApprovedByHod(expense.getApprovedByHod());

      updatedExpense.setStatus(expense.getStatus());
      updatedExpense.setRemarks(expense.getRemarks());
      // Set other properties as needed

      ExpensesClaim savedExpense = expensesClaimService.updateExpense(updatedExpense);
      return ResponseEntity.ok(savedExpense);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  /**
   * Deletes an expense by ID.
   *
   * @param expenseId ID of the expense to delete
   * @return No content if successfully deleted, or 404 Not Found status
   */
  @DeleteMapping("/{expenseId}")
  public ResponseEntity<Void> deleteExpense(@PathVariable Long expenseId) {
    Optional<ExpensesClaim> existingExpense = expensesClaimService.getExpenseById(expenseId);
    if (existingExpense.isPresent()) {
      expensesClaimService.deleteExpense(expenseId);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  /**
   * Updates the status of an expense.
   */
  @PatchMapping("/{expenseId}/status")
  public ResponseEntity<Void> updateExpenseStatus(@PathVariable Long expenseId, @RequestBody ExpenseStatus newStatus) {
    boolean updated = expensesClaimService.updateExpenseStatus(expenseId, newStatus);
    if (updated) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
