package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@SQLDelete(sql = "UPDATE account SET enabled = false WHERE account_number = ?")
@SQLRestriction("enabled = true")
public class Account {               // TODO: SP para crear cuentas y verificar condiciones (se debe iniciar con monto de $10000)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_sequence",  initialValue = 100, allocationSize = 1)
    @EqualsAndHashCode.Include
    private Integer accountNumber;

    @Column(nullable = false, length = 16, unique = true)
    private Long cbu;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, foreignKey = @ForeignKey(name = "FX_CLIENT_ACCOUNT"))
    private Client client;                   //TODO: SP para que un cliente no pueda tener más de 3 cuentas.
                                            //Una cuenta puede pertenecer solo a un cliente
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false, foreignKey = @ForeignKey(name = "FX_ACCOUNT_TYPE"))
    private AccountType accountType;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private double balance;

    @Column(nullable = false)
    private LocalDateTime dateTime = LocalDateTime.now();

    private boolean enabled = Boolean.TRUE;
}
