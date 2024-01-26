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
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator= "loan_seq")
    @GenericGenerator(name = "loan_seq", strategy="increment")
    @EqualsAndHashCode.Include
    @JsonAlias(value = {"loanId", "id", "loan_id"})
    private Integer loanId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, foreignKey = @ForeignKey(name = "FX_LOAN_CLIENT"))
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