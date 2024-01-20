package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "table_role")
@SQLDelete(sql = "UPDATE table_role SET enabled = false WHERE role_id = ?")  //logical deletion (Soft Delete)
//@Where(clause = "enabled = true")  //deprecated
@SQLRestriction("enabled = true")   //o  "enabled < > true"
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer roleId;

    @Column(length = 20, nullable = false)
    private String roleName;

    private boolean enabled = Boolean.TRUE;
}

