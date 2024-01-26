package com.cecifz.sistemabancario_poo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
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
@SQLDelete(sql = "UPDATE transaction_type SET enabled = false WHERE transaction_type_id = ?")
@SQLRestriction("enabled = true")
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator= "tranType_seq")
    @GenericGenerator(name = "tranType_seq", strategy="increment")
    @EqualsAndHashCode.Include
    @JsonAlias(value = {"typeId", "id", "type_id"})
    private Integer typeId;

    @Column(length = 20, nullable = false, unique = true)
    private String description;

    private boolean enabled = Boolean.TRUE;
}
