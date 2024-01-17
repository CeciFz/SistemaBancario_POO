package com.cecifz.sistemabancario_poo.repository;

import com.cecifz.sistemabancario_poo.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountTypeRepo extends IGenericRepo<AccountType, Integer> {
}
