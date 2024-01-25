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
public class LoanDto {
    private Integer id;
    private String dniClient;
    private LocalDate date;
    private double loanAmount;
    private double finalAmount;
    private int paymentDeadline;
    private double monthlyAmount;
    private int installments;
    private boolean cancelled;
}
