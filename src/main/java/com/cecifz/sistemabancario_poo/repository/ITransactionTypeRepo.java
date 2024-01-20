package com.cecifz.sistemabancario_poo.repository;

import com.cecifz.sistemabancario_poo.model.TransactionType;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionTypeRepo extends IGenericRepo<TransactionType, Integer> {
}
