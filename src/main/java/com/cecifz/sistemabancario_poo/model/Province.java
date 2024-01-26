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
@SQLDelete(sql = "UPDATE province SET enabled = false WHERE province_id = ?")
@SQLRestriction("enabled = true")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator= "province_seq")
    @GenericGenerator(name = "province_seq", strategy="increment")
    @EqualsAndHashCode.Include
    @JsonAlias(value = {"provinceId", "id", "province_id"})
    private Integer provinceId;

    @Column(length = 50, nullable = false, unique = true)
    private String description;

    private boolean enabled = Boolean.TRUE;
}
