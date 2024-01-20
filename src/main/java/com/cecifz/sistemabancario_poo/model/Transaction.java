package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
//@SQLDelete(sql = "UPDATE city SET enabled = false WHERE id_city = ?")
//@SQLRestriction("enabled = true")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idTransaction;

    @ManyToOne
    @JoinColumn(name = "account_number", nullable = false, foreignKey = @ForeignKey(name = "FX_ACCOUNT_NUMBER"))
    private Account account;

    @Column(nullable = false)
    private LocalDate date = LocalDate.now();

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "id_transaction_Type", nullable = false, foreignKey = @ForeignKey(name = "FX_MOVEMENT_TYPE"))
    private TransactionType transactionType;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private double balance;

    @Column(length = 50, nullable = false)
    private String description;

}
