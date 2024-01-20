package com.cecifz.sistemabancario_poo.service.impl;

import com.cecifz.sistemabancario_poo.model.TransactionType;
import com.cecifz.sistemabancario_poo.repository.IGenericRepo;
import com.cecifz.sistemabancario_poo.repository.ITransactionTypeRepo;
import com.cecifz.sistemabancario_poo.service.ITransactionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionTypeService extends CRUDServiceImpl<TransactionType, Integer> implements ITransactionTypeService {

    private final ITransactionTypeRepo transactionTypeRepo;
    @Override
    protected IGenericRepo<TransactionType, Integer> getRepo() {
        return transactionTypeRepo;
    }
}
