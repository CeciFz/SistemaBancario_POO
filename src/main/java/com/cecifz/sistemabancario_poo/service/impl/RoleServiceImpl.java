package com.cecifz.sistemabancario_poo.service.impl;

import com.cecifz.sistemabancario_poo.model.Role;
import com.cecifz.sistemabancario_poo.repository.IGenericRepo;
import com.cecifz.sistemabancario_poo.repository.IRoleRepo;
import com.cecifz.sistemabancario_poo.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends CRUDServiceImpl<Role, Integer> implements IRoleService {

    private final IRoleRepo roleRepo;

    @Override
    protected IGenericRepo<Role, Integer> getRepo() {
        return roleRepo;
    }
}
