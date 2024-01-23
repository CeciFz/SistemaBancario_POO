package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@SQLDelete(sql = "UPDATE account_type SET enabled = false WHERE account_type_id = ?")
@SQLRestriction("enabled = true")
public class AccountType {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    @EqualsAndHashCode.Include
    private Integer accountTypeId;

    @Column(length = 20, nullable = false)
    private String accountType;

    private boolean enabled = Boolean.TRUE;
}
