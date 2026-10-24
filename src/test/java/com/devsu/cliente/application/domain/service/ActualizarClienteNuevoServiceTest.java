package com.devsu.cliente.application.domain.service;

import com.devsu.cliente.application.domain.model.ClienteDto;
import com.devsu.cliente.application.port.in.ActualizarClienteUseCase;
import com.devsu.cliente.exception.ClienteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ActualizarClienteNuevoServiceTest extends ActualizarClienteAbstractServiceTest {

    @Test
    void guardarClienteSinIdentificacionTest() throws ClienteException {
        var cliente = new ClienteDto(0L, "", "", "", 0, "", "", "", true);
        var command = new ActualizarClienteUseCase.NuevoClienteCommand(cliente);
        validarExcepcionCliente(() -> actualizarClienteUseCase.guardarCliente(command));
    }

    @Test
    void guardarClienteSinNombreTest() throws ClienteException {
        var cliente = new ClienteDto(0L, "1234", "", "", 0, "", "", "", true);
        var command = new ActualizarClienteUseCase.NuevoClienteCommand(cliente);
        validarExcepcionCliente(() -> actualizarClienteUseCase.guardarCliente(command));
    }

    @Test
    void guardarClienteSinGeneroTest() throws ClienteException {
        var cliente = new ClienteDto(0L, "1234", "Wilmer", "", 0, "", "", "", true);
        var command = new ActualizarClienteUseCase.NuevoClienteCommand(cliente);
        validarExcepcionCliente(() -> actualizarClienteUseCase.guardarCliente(command));
    }

    @Test
    void guardarClienteSinContrasenaTest() throws ClienteException {
        var cliente = new ClienteDto(0L, "1234", "Wilmer", "M", 0, "", "", "", true);
        var command = new ActualizarClienteUseCase.NuevoClienteCommand(cliente);
        validarExcepcionCliente(() -> actualizarClienteUseCase.guardarCliente(command));
    }

    @Test
    void guardarTest() throws ClienteException {
        var cliente = new ClienteDto(0L, "1234", "Wilmer", "M", 0, "", "", "pass123", true);
        var command = new ActualizarClienteUseCase.NuevoClienteCommand(cliente);
        Assertions.assertDoesNotThrow(() -> actualizarClienteUseCase.guardarCliente(command));
    }

}
