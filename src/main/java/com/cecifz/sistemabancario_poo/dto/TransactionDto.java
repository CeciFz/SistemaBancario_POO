package com.cecifz.sistemabancario_poo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto {
    private Integer id;
    private Integer accountNumber;
    private LocalDate date;
    private double amount;
    private String transactionType;
    private double balance;
    private String description;
}
