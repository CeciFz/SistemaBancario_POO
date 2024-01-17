package com.cecifz.sistemabancario_poo.service.impl;

import com.cecifz.sistemabancario_poo.model.AccountType;
import com.cecifz.sistemabancario_poo.repository.IAccountTypeRepo;
import com.cecifz.sistemabancario_poo.repository.IGenericRepo;
import com.cecifz.sistemabancario_poo.service.IAccountTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountTypeServiceServiceImpl extends CRUDServiceImpl<AccountType, Integer> implements IAccountTypeService {

    private final IAccountTypeRepo accountTypeRepo;

    @Override
    protected IGenericRepo<AccountType, Integer> getRepo() {
        return accountTypeRepo;
    }

}
