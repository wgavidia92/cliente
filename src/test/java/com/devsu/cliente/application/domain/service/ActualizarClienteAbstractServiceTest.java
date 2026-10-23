package com.devsu.cliente.application.domain.service;

import com.devsu.cliente.application.port.in.ActualizarClienteUseCase;
import com.devsu.cliente.application.port.out.ActualizarClientePort;
import com.devsu.cliente.exception.ClienteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

class ActualizarClienteAbstractServiceTest {

    @MockitoBean
    ActualizarClientePort actualizarClientePort;

    ActualizarClienteUseCase actualizarClienteUseCase;

    @BeforeEach
    void init() {
        actualizarClienteUseCase = new ActualizarClienteService(actualizarClientePort);
    }

    void validarExcepcionCliente(Executable executable) {
        var excepcion = Assertions.assertThrows(ClienteException.class, executable);
        Assertions.assertEquals(ActualizarClienteUseCase.ERROR_VALIDACION_DATOS, excepcion.getMessage());
    }

}
