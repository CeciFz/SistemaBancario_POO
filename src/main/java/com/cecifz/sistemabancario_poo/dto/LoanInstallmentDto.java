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
public class LoanInstallmentDto {
    private Integer id;
    private Integer loanId;
    private int installmentNumber;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private double installmentAmount;
    private boolean cancelled;
}
