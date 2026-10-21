package com.devsu.cliente.domain.service;

import com.devsu.cliente.domain.exception.ClienteException;
import com.devsu.cliente.domain.model.Cliente;
import com.devsu.cliente.domain.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static com.devsu.cliente.domain.service.ClienteServiceImpl.ERROR_ACTUALIZANDO_INFORMACION;
import static com.devsu.cliente.domain.service.ClienteServiceImpl.ERROR_CLIENTE_NO_ENCONTRADO;

@ExtendWith(SpringExtension.class)
class ClienteServiceTest {

    @MockitoBean
    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @BeforeEach
    void init() {
        clienteService = new ClienteServiceImpl(clienteRepository);
    }

    @Test
    void findAllTest() {
        Mockito.when(clienteRepository.findAll())
                .thenReturn(List.of());
        Assertions.assertDoesNotThrow(() -> this.clienteService.findAll());
    }

    @Test
    void findByClienteNoEncontradoTest() {
        Mockito.when(clienteRepository.findByIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.empty());
        var exception = Assertions.assertThrows(ClienteException.class, () -> clienteService.findBy("123"));
        Assertions.assertEquals(ERROR_CLIENTE_NO_ENCONTRADO, exception.getMessage());
    }

    @Test
    void findByTest() {
        Mockito.when(clienteRepository.findByIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.of(generarCliente()));
        Assertions.assertDoesNotThrow(() -> clienteService.findBy("123"));
    }

    @Test
    void saveTest() {
        Assertions.assertDoesNotThrow(() -> clienteService.save(generarCliente()));
    }

    @Test
    void updateClienteNoExistenteTest() {
        Mockito.when(clienteRepository.findByIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.empty());
        var exception = Assertions.assertThrows(
                ClienteException.class, () -> clienteService.update("123", generarCliente()));
        Assertions.assertEquals(ERROR_ACTUALIZANDO_INFORMACION, exception.getMessage());
    }

    @Test
    void updateTest() {
        Mockito.when(clienteRepository.findByIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.of(generarCliente()));
        Assertions.assertDoesNotThrow(() -> clienteService.update("123", generarCliente()));
    }

    @Test
    void deleteClienteNoExistenteTest() {
        Mockito.when(clienteRepository.findByIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.empty());
        var exception = Assertions.assertThrows(ClienteException.class, () -> clienteService.deleteBy("1234"));
        Assertions.assertEquals(ERROR_ACTUALIZANDO_INFORMACION, exception.getMessage());
    }

    @Test
    void deleteTest() {
        Mockito.when(clienteRepository.findByIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.of(generarCliente()));
        Assertions.assertDoesNotThrow(() -> clienteService.deleteBy("1234"));
    }

    private Cliente generarCliente() {
        return new Cliente(1L, "", "", "", 1, "", "", "", "");
    }

}
