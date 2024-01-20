package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@SQLDelete(sql = "UPDATE phone SET enabled = false WHERE phone_number = ?")
@SQLRestriction("enabled = true")
public class Phone {
    @Id
    @Column(length = 20, nullable = false)
    @EqualsAndHashCode.Include
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "dni", nullable = false, foreignKey = @ForeignKey(name = "FK_PHONE_NUMBER"))
    private Client clientPhone;

}
