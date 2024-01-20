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
@SQLDelete(sql = "UPDATE city SET enabled = false WHERE city_id = ?")
@SQLRestriction("enabled = true")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer cityId;

    @Column(length = 50, nullable = false)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "province_id", nullable = false, foreignKey = @ForeignKey(name = "FX_PROVINCE"))
    private Province province;

    private boolean enabled = Boolean.TRUE;
}
