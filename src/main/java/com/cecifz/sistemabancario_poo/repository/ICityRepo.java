package com.cecifz.sistemabancario_poo.repository;

import com.cecifz.sistemabancario_poo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepo extends IGenericRepo<City, Integer> {
}
