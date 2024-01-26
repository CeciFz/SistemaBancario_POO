package com.cecifz.sistemabancario_poo.service.impl;

import com.cecifz.sistemabancario_poo.model.Client;
import com.cecifz.sistemabancario_poo.repository.IClientRepo;
import com.cecifz.sistemabancario_poo.repository.IGenericRepo;
import com.cecifz.sistemabancario_poo.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends CRUDServiceImpl<Client, Integer> implements IClientService {

    private final IClientRepo clientRepo;

    @Override
    protected IGenericRepo<Client, Integer> getRepo() {
        return clientRepo;
    }
}
