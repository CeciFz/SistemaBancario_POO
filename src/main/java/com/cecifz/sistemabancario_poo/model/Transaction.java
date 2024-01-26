package com.cecifz.sistemabancario_poo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(strategy = GenerationType.AUTO,  generator= "tran_seq")
    @GenericGenerator(name = "tran_seq", strategy="increment")
    @EqualsAndHashCode.Include
    @JsonAlias(value = {"transactionId", "id", "transaction_id"})
    private Integer transactionId;

    @ManyToOne
    @JoinColumn(name = "account_number", nullable = false, foreignKey = @ForeignKey(name = "FX_ACCOUNT_NUMBER"))
    private Account account;

    @Column(nullable = false)
    private LocalDate date = LocalDate.now();

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false, foreignKey = @ForeignKey(name = "FX_TRANSACTION_TYPE"))
    private TransactionType transactionType;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private double balance;

    @Column(length = 50, nullable = false)
    private String description;

}
