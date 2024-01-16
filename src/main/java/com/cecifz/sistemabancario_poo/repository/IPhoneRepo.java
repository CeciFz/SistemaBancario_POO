package com.cecifz.sistemabancario_poo.repository;

import com.cecifz.sistemabancario_poo.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneRepo extends JpaRepository<Phone, String> {
}
