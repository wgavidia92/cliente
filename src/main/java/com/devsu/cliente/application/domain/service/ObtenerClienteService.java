package com.devsu.cliente.application.domain.service;

import com.devsu.cliente.application.domain.model.ClienteDto;
import com.devsu.cliente.application.port.in.ObtenerClienteUseCase;
import com.devsu.cliente.application.port.out.ObtenerClientePort;
import com.devsu.cliente.exception.ClienteException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ObtenerClienteService implements ObtenerClienteUseCase {

    private final ObtenerClientePort obtenerClientePort;

    ObtenerClienteService(ObtenerClientePort obtenerClientePort) {
        this.obtenerClientePort = obtenerClientePort;
    }

    @Override
    public List<ClienteDto> obtenerClientes() {
        return obtenerClientePort.obtenerClientes();
    }

    @Override
    public ClienteDto obtenerClientePorIdentificacion(IdentificacionQuery query) throws ClienteException {
        query.validar();
        return obtenerClientePort.obtenerClientePorIdentificacion(query.identificacion())
                .orElseThrow(() -> new ClienteException("Cliente no encontrado"));
    }

}
