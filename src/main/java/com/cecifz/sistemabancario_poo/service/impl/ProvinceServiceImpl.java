package com.cecifz.sistemabancario_poo.service.impl;

import com.cecifz.sistemabancario_poo.model.Province;
import com.cecifz.sistemabancario_poo.repository.IGenericRepo;
import com.cecifz.sistemabancario_poo.repository.IProvinceRepo;
import com.cecifz.sistemabancario_poo.service.IProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl extends CRUDServiceImpl<Province, Integer> implements IProvinceService {

    private final IProvinceRepo provinceRepo;
    @Override
    protected IGenericRepo<Province, Integer> getRepo() {
        return provinceRepo;
    }
}
