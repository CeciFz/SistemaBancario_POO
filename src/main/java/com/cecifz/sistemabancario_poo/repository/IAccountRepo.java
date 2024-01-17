package com.cecifz.sistemabancario_poo.repository;

import com.cecifz.sistemabancario_poo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepo extends IGenericRepo<Account, Integer> {
}
