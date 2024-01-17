package com.cecifz.sistemabancario_poo.service.impl;

import com.cecifz.sistemabancario_poo.model.Account;
import com.cecifz.sistemabancario_poo.repository.IAccountRepo;
import com.cecifz.sistemabancario_poo.repository.IGenericRepo;
import com.cecifz.sistemabancario_poo.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceServiceImpl extends CRUDServiceImpl<Account, Integer> implements IAccountService {

    private final IAccountRepo accountRepo;

    @Override
    protected IGenericRepo<Account, Integer> getRepo() {
        return accountRepo;
    }

}
