package com.cecifz.sistemabancario_poo.service.impl;

import com.cecifz.sistemabancario_poo.repository.IGenericRepo;
import com.cecifz.sistemabancario_poo.service.ICRUDService;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUDService<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new Exception("ID NOT FOUND " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new Exception("ID NOT FOUND " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new Exception("ID NOT FOUND " + id));
        getRepo().deleteById(id);
    }
}
