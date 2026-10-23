package com.devsu.cliente.application.domain.service;

import com.devsu.cliente.application.port.in.ObtenerClienteUseCase;
import com.devsu.cliente.application.port.out.ObtenerClientePort;
import com.devsu.cliente.exception.ClienteException;
import com.devsu.cliente.util.UtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class ObtenerClienteServiceTest {

    @MockitoBean
    private ObtenerClientePort obtenerClientePort;

    private ObtenerClienteUseCase obtenerClienteUseCase;

    @BeforeEach
    void init() {
        obtenerClienteUseCase = new ObtenerClienteService(obtenerClientePort);
    }

    @Test
    void obtenerClientePorIdentificacionConExcepcionTest() throws ClienteException {
        Mockito.when(obtenerClientePort.obtenerClientePorIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.empty());
        var identificacionQuery = new ObtenerClienteUseCase.IdentificacionQuery("1234");
        var excepcion = Assertions.assertThrows(ClienteException.class,
                () -> obtenerClienteUseCase.obtenerClientePorIdentificacion(identificacionQuery));
        Assertions.assertEquals("Cliente no encontrado", excepcion.getMessage());
    }

    @Test
    void obtenerClientePorIdentificacionTest() throws ClienteException {
        Mockito.when(obtenerClientePort.obtenerClientePorIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.of(UtilsTest.generarCliente()));
        var identificacionQuery = new ObtenerClienteUseCase.IdentificacionQuery("1234");
        Assertions.assertDoesNotThrow(() -> obtenerClienteUseCase.obtenerClientePorIdentificacion(identificacionQuery));
    }

    @Test
    void obtenerClientesTest() {
        Mockito.when(obtenerClientePort.obtenerClientes())
                .thenReturn(List.of(UtilsTest.generarCliente()));
        Assertions.assertDoesNotThrow(() -> obtenerClienteUseCase.obtenerClientes());
    }

}
