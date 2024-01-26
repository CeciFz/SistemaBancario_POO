package com.cecifz.sistemabancario_poo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@SQLRestriction("cancelled = false")
public class LoanInstallment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator= "loanInst_seq")
    @GenericGenerator(name = "loanInst_seq", strategy="increment")
    @EqualsAndHashCode.Include
    @JsonAlias(value = {"loanInstId", "id", "loan_inst_id"})
    private Integer loanInstId;

    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = false, foreignKey = @ForeignKey(name = "FX_LOAN_INSTALLMENT"))
    private Loan loan;

    @Column(nullable = false)
    private int installmentNumber;

    @Column(nullable = false)
    private LocalDate dueDate;

    private LocalDate paymentDate;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private double installmentAmount;

    private boolean cancelled = Boolean.FALSE;

}
