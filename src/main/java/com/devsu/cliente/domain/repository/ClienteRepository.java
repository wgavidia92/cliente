package com.devsu.cliente.domain.repository;

import com.devsu.cliente.domain.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Override
    List<Cliente> findAll();

    Optional<Cliente> findByIdentificacion(String identificacion);

}
