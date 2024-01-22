package com.cecifz.sistemabancario_poo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {
    private Integer accountNumber;
    private Long cbu;
    private String dniClient;
    private String fullName;
    private String accountType;
    private double balance;
}
