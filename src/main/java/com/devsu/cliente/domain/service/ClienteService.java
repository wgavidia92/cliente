package com.devsu.cliente.domain.service;

import com.devsu.cliente.domain.exception.ClienteException;
import com.devsu.cliente.domain.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente findBy(String identificacion) throws ClienteException;

    Cliente save(Cliente cliente) throws ClienteException;

    Cliente update(String identificacion, Cliente cliente) throws ClienteException;

    void deleteBy(String identificacion) throws ClienteException;

}
