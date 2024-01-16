package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Integer nroCuenta;

    @Column(nullable = false, length = 16, unique = true)
    private Long cbu;

    @ManyToOne
    @JoinColumn(name = "dni", nullable = false, foreignKey = @ForeignKey(name = "FX_DNI_ACCOUNT"))
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_account_type", nullable = false, foreignKey = @ForeignKey(name = "FX_ACCOUNT_TYPE"))
    private AccountType accountType;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double balance;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    private boolean enabled;
}
