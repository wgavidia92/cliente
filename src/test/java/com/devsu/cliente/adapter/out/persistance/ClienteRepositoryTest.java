package com.devsu.cliente.adapter.out.persistance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jdbc.test.autoconfigure.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@DataJdbcTest
@ActiveProfiles("test")
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void findAll() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        Assertions.assertFalse(clientes.isEmpty());
    }

    @Test
    void findByIdentificacion() {
        Optional<ClienteEntity> cliente = clienteRepository.findByIdentificacion("123456");
        Assertions.assertTrue(cliente.isPresent());
        Assertions.assertEquals("Wilmer Gavidia", cliente.get().nombre());
    }

}
