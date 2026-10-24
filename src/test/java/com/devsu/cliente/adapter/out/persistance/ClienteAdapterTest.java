package com.devsu.cliente.adapter.out.persistance;

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
class ClienteAdapterTest {

    @MockitoBean
    private ClienteRepository clienteRepository;

    private ClienteAdapter clienteAdapter;

    @BeforeEach
    void init() {
        clienteAdapter = new ClienteAdapter(clienteRepository);
    }

    @Test
    void obtenerClientesTest() {
        Mockito.when(clienteRepository.findAll())
                .thenReturn(List.of());
        Assertions.assertDoesNotThrow(() -> this.clienteAdapter.obtenerClientes());
    }

    @Test
    void obtenerClientePorIdentificacionTest() {
        Mockito.when(clienteRepository.findByIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.empty());
        Assertions.assertDoesNotThrow(() -> clienteAdapter.obtenerClientePorIdentificacion("123"));
    }

    @Test
    void guardarClienteTest() {
        Mockito.when(clienteRepository.save(Mockito.any(ClienteEntity.class)))
                .thenReturn(generarClienteDB());
        Assertions.assertDoesNotThrow(() -> clienteAdapter.guardarCliente(UtilsTest.generarCliente()));
    }


    @Test
    void actualizarClienteNoExistenteTest() {
        Mockito.when(clienteRepository.findByIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.empty());
        var exception = Assertions.assertThrows(
                ClienteException.class, () -> clienteAdapter.actualizarCliente("123", UtilsTest.generarCliente()));
        Assertions.assertEquals(ClienteAdapter.ERROR_ACTUALIZANDO_INFORMACION, exception.getMessage());
    }

    @Test
    void actualizarClienteTest() {
        Mockito.when(clienteRepository.findByIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.of(generarClienteDB()));
        Mockito.when(clienteRepository.save(Mockito.any(ClienteEntity.class)))
                .thenReturn(generarClienteDB());
        Assertions.assertDoesNotThrow(() -> clienteAdapter.actualizarCliente("123", UtilsTest.generarCliente()));
    }

    @Test
    void eliminarClienteNoExistenteTest() {
        Mockito.when(clienteRepository.findByIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.empty());
        var exception = Assertions.assertThrows(ClienteException.class, () -> clienteAdapter.eliminarCliente("1234"));
        Assertions.assertEquals(ClienteAdapter.ERROR_ACTUALIZANDO_INFORMACION, exception.getMessage());
    }

    @Test
    void eliminarClienteTest() {
        Mockito.when(clienteRepository.findByIdentificacion(Mockito.anyString()))
                .thenReturn(Optional.of(generarClienteDB()));
        Assertions.assertDoesNotThrow(() -> clienteAdapter.eliminarCliente("1234"));
    }

    private ClienteEntity generarClienteDB() {
        return new ClienteEntity(
                1L,
                "",
                "",
                "",
                1,
                "",
                "",
                "",
                true);
    }

}
