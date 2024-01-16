package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Client {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 8, unique = true)
    private String dni;

    @Column(length = 50, nullable = false)
    private String names;

    @Column(length = 50, nullable = false)
    private String lastNames;

    @Column(nullable = false, length = 11, unique = true)
    private String cuil;

    private char sex;

    private LocalDateTime birthday;

    @Column(length = 200, nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_city", nullable = false, foreignKey = @ForeignKey(name = "FX_CITY"))
    private City city;

    @OneToMany(mappedBy = "clientPhone", cascade = CascadeType.ALL)
    private List<Phone> phoneList;

    private String email;

    private boolean enabled;
}
