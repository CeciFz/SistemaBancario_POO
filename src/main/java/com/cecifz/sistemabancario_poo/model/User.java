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
@Table(name = "user_account")
@SQLDelete(sql = "UPDATE user_account SET enabled = false WHERE user_id = ?")
@SQLRestriction("enabled = true")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator= "user_seq")
    @GenericGenerator(name = "user_seq", strategy="increment")
    @EqualsAndHashCode.Include
    @JsonAlias(value = {"userId", "id", "user_id"})
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "FX_USER_ROLE"))
    private Role role;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(length = 60, nullable = false)  // luego con una librería (Bcscrypt) lo encripto en algo largo
    private String password;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, foreignKey = @ForeignKey(name = "FX_CLIENT_USER"))
    private Client client;

    private boolean enabled = Boolean.TRUE;

}
