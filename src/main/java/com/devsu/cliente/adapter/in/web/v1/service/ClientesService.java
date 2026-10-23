package com.devsu.cliente.adapter.in.web.v1.service;

import com.devsu.cliente.adapter.in.web.v1.ClientesApi;
import com.devsu.cliente.adapter.in.web.v1.mapper.ClienteMapper;
import com.devsu.cliente.adapter.in.web.v1.model.Cliente;
import com.devsu.cliente.application.port.in.ActualizarClienteUseCase;
import com.devsu.cliente.application.port.in.ObtenerClienteUseCase;
import com.devsu.cliente.exception.ClienteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ClientesService implements ClientesApi {

    private final ObtenerClienteUseCase obtenerClienteUseCase;
    private final ActualizarClienteUseCase actualizarClienteUseCase;

    ClientesService(ObtenerClienteUseCase obtenerClienteUseCase, ActualizarClienteUseCase actualizarClienteUseCase) {
        this.obtenerClienteUseCase = obtenerClienteUseCase;
        this.actualizarClienteUseCase = actualizarClienteUseCase;
    }

    @Override
    public ResponseEntity<Void> _actualizarCliente(String identificacion, Cliente cliente) throws ClienteException {
        var command = new ActualizarClienteUseCase.ClienteCommand(identificacion, ClienteMapper.from(cliente));
        actualizarClienteUseCase.actualizarCliente(command);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Cliente> _createCliente(Cliente cliente) throws ClienteException {
        var command = new ActualizarClienteUseCase.NuevoClienteCommand(ClienteMapper.from(cliente));
        var nuevoCliente = actualizarClienteUseCase.guardarCliente(command);
        return ResponseEntity.ok(ClienteMapper.from(nuevoCliente));
    }

    @Override
    public ResponseEntity<Void> _deleteUser(String identificacion) throws ClienteException {
        var command = new ActualizarClienteUseCase.IdentificacionCommand(identificacion);
        actualizarClienteUseCase.eliminarCliente(command);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Cliente> _getClienteByIdentificacion(String identificacion) throws ClienteException {
        var query = new ObtenerClienteUseCase.IdentificacionQuery(identificacion);
        var cliente = obtenerClienteUseCase.obtenerClientePorIdentificacion(query);
        return ResponseEntity.ok(ClienteMapper.from(cliente));
    }

    @Override
    public ResponseEntity<List<Cliente>> _obtenerClientes() throws ClienteException {
        var clientes = obtenerClienteUseCase.obtenerClientes()
                .stream()
                .map(ClienteMapper::from)
                .toList();
        return ResponseEntity.ok(clientes);
    }

}
