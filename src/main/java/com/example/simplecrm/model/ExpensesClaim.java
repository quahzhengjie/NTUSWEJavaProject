package com.example.simplecrm.model;

import com.example.simplecrm.model.ExpenseStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
public class ExpensesClaim {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "expense_id")
  private Long expenseId;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "category")
  private String category;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private ExpenseStatus status;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "created_date")
  private LocalDate createdDate;

  @Column(name = "created_by_id")
  private int createdById;

  @Column(name = "created_by_name")
  private String createdByName;

  @Column(name = "supervisor_name_responded")
  private String supervisorName;

  @Column(name = "supervisor_id_responded")
  private int supervisorId;

  public int getSupervisorId() {
    return supervisorId;
  }

  public void setSupervisorId(int supervisorId) {
    this.supervisorId = supervisorId;
  }

  public String getSupervisorName() {
    return supervisorName;
  }

  public void setSupervisorName(String supervisorName) {
    this.supervisorName = supervisorName;
  }

  public String getCreatedByName() {
    return createdByName;
  }

  public void setCreatedByName(String createdByName) {
    this.createdByName = createdByName;
  }

  public int getCreatedById() {
    return createdById;
  }

  public void setCreatedById(int createdById) {
    this.createdById = createdById;
  }

  public Long getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(Long expenseId) {
    this.expenseId = expenseId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public ExpenseStatus getStatus() {
    return status;
  }

  public void setStatus(ExpenseStatus status) {
    this.status = status;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  // Constructors, getters, setters, and other methods

}
