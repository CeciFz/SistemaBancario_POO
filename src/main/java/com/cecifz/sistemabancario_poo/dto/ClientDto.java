package com.cecifz.sistemabancario_poo.dto;

import com.cecifz.sistemabancario_poo.model.Phone;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {
    private Integer id;
    private String dni;
    private String fullName;
    private String cuil;
    private char sex;
    private LocalDate birthdate;
    private String address;

    @JsonIncludeProperties(value = {"phoneNumber", "detail"})
    private List<Phone> phones;

    private String email;
}
