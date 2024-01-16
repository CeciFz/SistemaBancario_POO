package com.cecifz.sistemabancario_poo.repository;

import com.cecifz.sistemabancario_poo.model.MovementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovementTypeRepo extends JpaRepository<MovementType, Integer> {
}
