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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    @GeneratedValue(strategy = GenerationType.AUTO,  generator= "client_seq")
    @GenericGenerator(name = "client_seq", strategy="increment")
    @JsonAlias(value = {"clientId", "id", "client_id"})
    private Integer clientId;

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

    public String getFullName() {
        /*return this.getLastNames() +
                ", " +  this.getNames();*/

        return Optional.ofNullable(this.getLastNames())
                .map(n -> n + ", " +  this.getNames())
                .orElseGet(() -> null);
    }

    public String getFullAddress() {

        String cityName = Optional.ofNullable(this.getCity())
               .map(c -> c.getCityName())
                .orElseGet(() -> null);

        if (cityName != null) {
            return this.getAddress() +
                    ", " + cityName +
                    ", " + this.getCity().getProvince().getDescription();
        }

        return this.getAddress();
    }

    /*  public String getFullAddress() {

        if (this.getCity().getCityName() != null) {
            return this.getAddress() +
                    ", " + this.getCity().getCityName() +
                    ", " + this.getCity().getProvince().getDescription();
        }

        return this.getAddress();
    }*/
}
