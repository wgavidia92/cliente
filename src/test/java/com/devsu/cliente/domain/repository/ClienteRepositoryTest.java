package com.devsu.cliente.domain.repository;

import com.devsu.cliente.domain.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jdbc.test.autoconfigure.DataJdbcTest;

import java.util.List;
import java.util.Optional;

@DataJdbcTest
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        Assertions.assertFalse(clientes.isEmpty());
    }

    @Test
    void findByIdentificacion() {
        Optional<Cliente> cliente = clienteRepository.findByIdentificacion("123456");
        Assertions.assertTrue(cliente.isPresent());
        Assertions.assertEquals("Wilmer Gavidia", cliente.get().nombre());
    }



}
