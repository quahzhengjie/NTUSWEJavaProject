package com.example.simplecrm.model;

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

  @ManyToOne
  @JoinColumn(name = "created_by")
  private Employee createdBy;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "category")
  private String category;

  @ManyToOne
  @JoinColumn(name = "approved_by_supervisor")
  private Employee approvedBySupervisor;

  @ManyToOne
  @JoinColumn(name = "approved_by_hod")
  private Employee approvedByHod;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private ExpenseStatus status;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "created_date")
  private LocalDate createdDate;

  public Long getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(Long expenseId) {
    this.expenseId = expenseId;
  }

  public Employee getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Employee createdBy) {
    this.createdBy = createdBy;
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

  public Employee getApprovedBySupervisor() {
    return approvedBySupervisor;
  }

  public void setApprovedBySupervisor(Employee approvedBySupervisor) {
    this.approvedBySupervisor = approvedBySupervisor;
  }

  public Employee getApprovedByHod() {
    return approvedByHod;
  }

  public void setApprovedByHod(Employee approvedByHod) {
    this.approvedByHod = approvedByHod;
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
