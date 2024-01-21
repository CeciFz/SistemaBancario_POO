package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@SQLDelete(sql = "UPDATE client SET enabled = false WHERE dni = ?")
@SQLRestriction("enabled = true")
public class Client {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 8, unique = true)
    private String dni;

    @Column(length = 50, nullable = false)
    private String names;

    @Column(length = 50, nullable = false)
    private String lastNames;

    @Column(nullable = false, length = 13, unique = true)
    private String cuil;

    private char sex;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(length = 200, nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false, foreignKey = @ForeignKey(name = "FX_CITY"))
    private City city;

    @OneToMany(mappedBy = "clientPhone", cascade = CascadeType.ALL)
    private List<Phone> phoneList;

    private String email;

    private boolean enabled = Boolean.TRUE;
}
