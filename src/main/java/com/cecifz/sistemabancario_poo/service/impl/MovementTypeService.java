package com.cecifz.sistemabancario_poo.service.impl;

import com.cecifz.sistemabancario_poo.model.MovementType;
import com.cecifz.sistemabancario_poo.repository.IGenericRepo;
import com.cecifz.sistemabancario_poo.repository.IMovementTypeRepo;
import com.cecifz.sistemabancario_poo.service.IMovementTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovementTypeService extends CRUDServiceImpl<MovementType, Integer> implements IMovementTypeService {

    private final IMovementTypeRepo movementTypeRepo;
    @Override
    protected IGenericRepo<MovementType, Integer> getRepo() {
        return movementTypeRepo;
    }
}
