package com.cecifz.sistemabancario_poo.repository;

import com.cecifz.sistemabancario_poo.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepo extends JpaRepository<Province, Integer> {
}
