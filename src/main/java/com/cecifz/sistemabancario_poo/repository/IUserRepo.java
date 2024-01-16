package com.cecifz.sistemabancario_poo.repository;

import com.cecifz.sistemabancario_poo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {
}
