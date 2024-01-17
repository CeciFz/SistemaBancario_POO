package com.cecifz.sistemabancario_poo.service.impl;

import com.cecifz.sistemabancario_poo.model.City;
import com.cecifz.sistemabancario_poo.repository.ICityRepo;
import com.cecifz.sistemabancario_poo.repository.IGenericRepo;
import com.cecifz.sistemabancario_poo.service.ICityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceServiceImpl extends CRUDServiceImpl<City, Integer> implements ICityService {

    private final ICityRepo cityRepo;

    @Override
    protected IGenericRepo<City, Integer> getRepo() {
        return cityRepo;
    }

}
