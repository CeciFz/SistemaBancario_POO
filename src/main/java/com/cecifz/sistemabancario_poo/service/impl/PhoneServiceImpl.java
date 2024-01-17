package com.cecifz.sistemabancario_poo.service.impl;

import com.cecifz.sistemabancario_poo.model.Phone;
import com.cecifz.sistemabancario_poo.repository.IGenericRepo;
import com.cecifz.sistemabancario_poo.repository.IPhoneRepo;
import com.cecifz.sistemabancario_poo.service.IPhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl extends CRUDServiceImpl<Phone, String> implements IPhoneService {

    private final IPhoneRepo phoneRepo;

    @Override
    protected IGenericRepo<Phone, String> getRepo() {
        return phoneRepo;
    }
}
