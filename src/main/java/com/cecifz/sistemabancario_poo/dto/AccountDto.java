package com.cecifz.sistemabancario_poo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
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
    @JsonIncludeProperties(value = {"id", "fullName"})
    private ClientDto client;
    @JsonIncludeProperties(value = {"id", "description"})
    private AccountTypeDto accountType;
    private double balance;
}
