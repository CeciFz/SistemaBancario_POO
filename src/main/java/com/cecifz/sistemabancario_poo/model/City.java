package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCity;

    @Column(length = 50, nullable = false)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "id_province", nullable = false, foreignKey = @ForeignKey(name = "FX_PROVINCE"))
    private Province province;

    private boolean enabled;
}
