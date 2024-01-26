package com.cecifz.sistemabancario_poo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JoinColumn(name = "client_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PHONE_NUMBER"))
    @JsonBackReference
    private Client client;

    @Column(length = 20)
    private String detail;

    private boolean enabled = Boolean.TRUE;

}
