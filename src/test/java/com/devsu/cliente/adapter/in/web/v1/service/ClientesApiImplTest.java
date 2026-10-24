package com.devsu.cliente.adapter.in.web.v1.service;

import com.devsu.cliente.adapter.in.web.v1.ClientesApi;
import com.devsu.cliente.application.port.in.ActualizarClienteUseCase;
import com.devsu.cliente.application.port.in.ObtenerClienteUseCase;
import com.devsu.cliente.exception.ClienteException;
import com.devsu.cliente.util.UtilsTest;
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
                  "estado": true
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
                  "estado": true
                }
                """;

        Mockito.when(actualizarClienteUseCase.actualizarCliente(Mockito.any(ActualizarClienteUseCase.ClienteCommand.class)))
                .thenThrow(new ClienteException("Test"));

        final String codigoError = "\"codigo\":\"99\"";
        final String mensajeError = "\"mensaje\":\"Test\"";

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
    void _crearClienteTest() throws Exception {
        final String fakeRequest = """
                {
                  "identificacion": "123456",
                  "nombre": "cliente",
                  "genero": "M",
                  "edad": 20,
                  "direccion": "carrera 1",
                  "contrasena": "pass1234",
                  "telefono": "12345",
                  "estado": true
                }
                """;

        var cliente = UtilsTest.generarCliente();

        Mockito.when(actualizarClienteUseCase.guardarCliente(Mockito.any(ActualizarClienteUseCase.NuevoClienteCommand.class)))
                .thenReturn(cliente);

        final String clienteId = "\"cliente_id\":1";

        var url = ClientesApi.PATH_CREAR_CLIENTE;
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(fakeRequest))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(clienteId)))
        ;
    }

    @Test
    void _crearClienteConExcepcionTest() throws Exception {
        final String fakeRequest = """
                {
                  "identificacion": "",
                  "nombre": "cliente",
                  "genero": "M",
                  "edad": 20,
                  "direccion": "carrera 1",
                  "contrasena": "pass1234",
                  "telefono": "12345",
                  "estado": true
                }
                """;

        Mockito.when(actualizarClienteUseCase.guardarCliente(Mockito.any(ActualizarClienteUseCase.NuevoClienteCommand.class)))
                .thenThrow(new ClienteException("Test"));

        final String codigoError = "\"codigo\":\"99\"";
        final String mensajeError = "\"mensaje\":\"Test\"";

        var url = ClientesApi.PATH_CREAR_CLIENTE;
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
    void _eliminarClienteTest() throws Exception {
        var url = ClientesApi.PATH_ELIMINAR_CLIENTE.replace("{identificacion}", "123456");
        mockMvc.perform(MockMvcRequestBuilders.delete(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
    }

    @Test
    void _eliminarClienteConExcepcionTest() throws Exception {

        Mockito.doThrow(new ClienteException("Test"))
                .when(actualizarClienteUseCase)
                .eliminarCliente(Mockito.any(ActualizarClienteUseCase.IdentificacionCommand.class));

        final String codigoError = "\"codigo\":\"99\"";
        final String mensajeError = "\"mensaje\":\"Test\"";

        var url = ClientesApi.PATH_ACTUALIZAR_CLIENTE.replace("{identificacion}", "123456");
        mockMvc.perform(MockMvcRequestBuilders.delete(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(codigoError)))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(mensajeError)))
        ;
    }

    @Test
    void _obtenerClientePorIdentificacionTest() throws Exception {
        var cliente = UtilsTest.generarCliente();
        Mockito.when(obtenerClienteUseCase.obtenerClientePorIdentificacion(Mockito.any(ObtenerClienteUseCase.IdentificacionQuery.class)))
                .thenReturn(cliente);
        final String clienteId = "\"cliente_id\":1";

        var url = ClientesApi.PATH_OBTENER_CLIENTE_POR_IDENTIFICACION.replace("{identificacion}", "123456");
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(clienteId)))
        ;
    }

    @Test
    void _obtenerClientePorIdentificacionSinClienteExistenteTest() throws Exception {
        Mockito.when(obtenerClienteUseCase.obtenerClientePorIdentificacion(Mockito.any(ObtenerClienteUseCase.IdentificacionQuery.class)))
                .thenThrow(new ClienteException("Test"));

        final String codigoError = "\"codigo\":\"99\"";
        final String mensajeError = "\"mensaje\":\"Test\"";

        var url = ClientesApi.PATH_OBTENER_CLIENTE_POR_IDENTIFICACION.replace("{identificacion}", "123456");
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(codigoError)))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(mensajeError)))
        ;
    }
}
