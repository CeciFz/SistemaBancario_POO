package com.cecifz.sistemabancario_poo.model;

import jakarta.persistence.*;

public class Phone {
    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "dni", nullable = false, foreignKey = @ForeignKey(name = "FK_PHONE_NUMBER"))
    private Client clientPhone;

}
