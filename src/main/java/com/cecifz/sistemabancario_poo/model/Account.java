package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@SQLDelete(sql = "UPDATE account SET enabled = false WHERE account_number = ?")
@SQLRestriction("enabled = true")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Integer accountNumber;

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
