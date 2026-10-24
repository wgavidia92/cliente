package com.devsu.cliente.adapter.in.web.v1.service;

import com.devsu.cliente.adapter.in.web.v1.ClientesApi;
import com.devsu.cliente.application.domain.model.ClienteDto;
import com.devsu.cliente.application.port.in.ActualizarClienteUseCase;
import com.devsu.cliente.application.port.in.ObtenerClienteUseCase;
import com.devsu.cliente.exception.ClienteException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ClientesApi.class)
class ClientesApiImplTest {

    @MockitoBean
    private ObtenerClienteUseCase obtenerClienteUseCase;
    @MockitoBean
    private ActualizarClienteUseCase actualizarClienteUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void _actualizarClienteTest() throws Exception {
        final String fakeRequest = """
                {
                  "cliente_id": 10,
                  "identificacion": "123456",
                  "nombre": "cliente",
                  "genero": "M",
                  "edad": 20,
                  "direccion": "carrera 1",
                  "contrasena": "pass1234",
                  "telefono": "12345",
                  "estado": "A"
                }
                """;
        var url = ClientesApi.PATH_ACTUALIZAR_CLIENTE.replace("{identificacion}", "123456");
        mockMvc.perform(MockMvcRequestBuilders.put(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(fakeRequest))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
    }

    @Test
    void _actualizarClienteConExcepcionTest() throws Exception {
        final String fakeRequest = """
                {
                  "cliente_id": 10,
                  "identificacion": "123456",
                  "nombre": "cliente",
                  "genero": "M",
                  "edad": 20,
                  "direccion": "carrera 1",
                  "contrasena": "pass1234",
                  "telefono": "12345",
                  "estado": "A"
                }
                """;

        Mockito.when(actualizarClienteUseCase.actualizarCliente(Mockito.any(ActualizarClienteUseCase.ClienteCommand.class)))
                .thenThrow(new ClienteException("Test"));

        final String codigoError = "\"code\":\"99\"";
        final String mensajeError = "\"message\":\"Test\"";

        var url = ClientesApi.PATH_ACTUALIZAR_CLIENTE.replace("{identificacion}", "123456");
        mockMvc.perform(MockMvcRequestBuilders.put(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(fakeRequest))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(codigoError)))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(mensajeError)))
        ;
    }

    @Test
    void _createClienteTest() throws Exception {
        final String fakeRequest = """
                {
                  "identificacion": "123456",
                  "nombre": "cliente",
                  "genero": "M",
                  "edad": 20,
                  "direccion": "carrera 1",
                  "contrasena": "pass1234",
                  "telefono": "12345",
                  "estado": "A"
                }
                """;

        var cliente = new ClienteDto(
                1L,
                "123456",
                "cliente",
                "M",
                20,
                "carrera 1",
                "12345",
                "pass1234",
                "A");

        Mockito.when(actualizarClienteUseCase.guardarCliente(Mockito.any(ActualizarClienteUseCase.NuevoClienteCommand.class)))
                .thenReturn(cliente);

        final String clienteId = "\"cliente_id\":1";

        var url = ClientesApi.PATH_CREATE_CLIENTE;
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(fakeRequest))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(clienteId)))
        ;
    }

    @Test
    void _createClienteConExcepcionTest() throws Exception {
        final String fakeRequest = """
                {
                  "identificacion": "",
                  "nombre": "cliente",
                  "genero": "M",
                  "edad": 20,
                  "direccion": "carrera 1",
                  "contrasena": "pass1234",
                  "telefono": "12345",
                  "estado": "A"
                }
                """;

        Mockito.when(actualizarClienteUseCase.guardarCliente(Mockito.any(ActualizarClienteUseCase.NuevoClienteCommand.class)))
                .thenThrow(new ClienteException("Test"));

        final String codigoError = "\"code\":\"99\"";
        final String mensajeError = "\"message\":\"Test\"";

        var url = ClientesApi.PATH_CREATE_CLIENTE;
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(fakeRequest))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(codigoError)))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(mensajeError)))
        ;
    }

    @Test
    void _deleteUserTest() throws Exception {
        var url = ClientesApi.PATH_DELETE_USER.replace("{identificacion}", "123456");
        mockMvc.perform(MockMvcRequestBuilders.delete(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
    }

    @Test
    void _deleteUserConExcepcionTest() throws Exception {

        Mockito.doThrow(new ClienteException("Test"))
                .when(actualizarClienteUseCase)
                .eliminarCliente(Mockito.any(ActualizarClienteUseCase.IdentificacionCommand.class));

        final String codigoError = "\"code\":\"99\"";
        final String mensajeError = "\"message\":\"Test\"";

        var url = ClientesApi.PATH_ACTUALIZAR_CLIENTE.replace("{identificacion}", "123456");
        mockMvc.perform(MockMvcRequestBuilders.delete(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(codigoError)))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(mensajeError)))
        ;
    }

}
