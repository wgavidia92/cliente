package com.devsu.cliente.adapter.out.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {

    @Override
    List<ClienteEntity> findAll();

    Optional<ClienteEntity> findByIdentificacion(String identificacion);

}
