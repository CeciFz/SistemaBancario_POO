package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@SQLRestriction("cancelled = false")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer loanId;

    @ManyToOne
    @JoinColumn(name = "dni", nullable = false, foreignKey = @ForeignKey(name = "FX_LOAN_CLIENT"))
    private Client client;

    private LocalDate date = LocalDate.now();

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private double loanAmount;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private double finalAmount;

    @Column(nullable = false)
    private int paymentDeadline;   //cant meses

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private double monthlyAmount;

    @Column(nullable = false)
    private int installments;

    private boolean cancelled = Boolean.FALSE;
}