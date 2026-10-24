package com.devsu.cliente.application.domain.service;

import com.devsu.cliente.application.domain.model.ClienteDto;
import com.devsu.cliente.application.port.in.ActualizarClienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ActualizarClienteExistenteServiceTest extends ActualizarClienteAbstractServiceTest {

    @Test
    void actualizarClienteSinIdentificacionTest() {
        var cliente = new ClienteDto(0L, "", "", "", 0, "", "", "", true);
        var command = new ActualizarClienteUseCase.ClienteCommand("", cliente);
        validarExcepcionCliente(() -> actualizarClienteUseCase.actualizarCliente(command));
    }

    @Test
    void actualizarClienteSinClienteIdTest() {
        var cliente = new ClienteDto(-1L, "", "", "", 0, "", "", "", true);
        var command = new ActualizarClienteUseCase.ClienteCommand("1234", cliente);
        validarExcepcionCliente(() -> actualizarClienteUseCase.actualizarCliente(command));
    }

    @Test
    void guardarClienteSinNombreTest() {
        var cliente = new ClienteDto(1L, "", "", "", 0, "", "", "", true);
        var command = new ActualizarClienteUseCase.ClienteCommand("1234", cliente);
        validarExcepcionCliente(() -> actualizarClienteUseCase.actualizarCliente(command));
    }

    @Test
    void guardarClienteSinGeneroTest() {
        var cliente = new ClienteDto(1L, "1234", "Wilmer", "", 0, "", "", "", true);
        var command = new ActualizarClienteUseCase.ClienteCommand("1234", cliente);
        validarExcepcionCliente(() -> actualizarClienteUseCase.actualizarCliente(command));
    }

    @Test
    void guardarClienteSinContrasenaTest() {
        var cliente = new ClienteDto(1L, "1234", "Wilmer", "M", 0, "", "", "", true);
        var command = new ActualizarClienteUseCase.ClienteCommand("1234", cliente);
        validarExcepcionCliente(() -> actualizarClienteUseCase.actualizarCliente(command));
    }

    @Test
    void guardarTest() {
        var cliente = new ClienteDto(1L, "1234", "Wilmer", "M", 0, "", "", "pass123", true);
        var command = new ActualizarClienteUseCase.ClienteCommand("1234", cliente);
        Assertions.assertDoesNotThrow(() -> actualizarClienteUseCase.actualizarCliente(command));
    }

}
