package com.cecifz.sistemabancario_poo.service;

import java.util.List;

public interface ICRUDService<T, ID> {
    T save(T t) throws Exception;
    T update(T t, ID id) throws Exception;
    List<T> readAll() throws Exception;
    T readById(ID id) throws Exception;
    void delete(ID id) throws Exception;
}

/*
Resumen:
1- ICRUDService va a tener los métodos de JPA que hay quiero desarrollar.
2- CRUDServiceImpl además de desarrollar los métodos de ICRUDService, tiene un método abst getrepo() que
deberá desarrollar cada clase que extienda/herede de CRUDServiceImpl. Desarrolla los métodos usando ese getRepo()
3- Cada clase service, desarrollará el getRepo() retornando la instancia de IGenericRepo que inyecta,
a la cual le pasa los <T, ID> correspondientes.
*/
