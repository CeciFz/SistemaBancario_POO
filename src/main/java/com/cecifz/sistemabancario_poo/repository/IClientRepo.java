package com.cecifz.sistemabancario_poo.repository;

import com.cecifz.sistemabancario_poo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepo extends IGenericRepo<Client, String> {
}
