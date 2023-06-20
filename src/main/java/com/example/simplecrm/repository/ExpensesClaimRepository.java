package com.example.simplecrm.repository;

import com.example.simplecrm.model.ExpensesClaim;
import com.example.simplecrm.model.ExpenseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesClaimRepository extends JpaRepository<ExpensesClaim, Long> {

  List<ExpensesClaim> findByStatus(ExpenseStatus status);

  ExpensesClaim save(ExpensesClaim expense);

}
