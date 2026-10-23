package com.devsu.cliente.application.domain.service;

import com.devsu.cliente.application.port.in.ActualizarClienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class EliminarClienteServiceTest extends ActualizarClienteAbstractServiceTest {

    @Test
    void eliminarClienteSinIdentificacionTest() throws Exception {
        var command = new ActualizarClienteUseCase.IdentificacionCommand("");
        validarExcepcionCliente(() -> actualizarClienteUseCase.eliminarCliente(command));
    }

    @Test
    void eliminarClienteTest() {
        var command = new ActualizarClienteUseCase.IdentificacionCommand("1234");
        Assertions.assertDoesNotThrow(() -> actualizarClienteUseCase.eliminarCliente(command));
    }

}
