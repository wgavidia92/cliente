package com.devsu.cliente.application.domain.service;

import com.devsu.cliente.application.domain.model.ClienteDto;
import com.devsu.cliente.application.port.in.ActualizarClienteUseCase;
import com.devsu.cliente.application.port.out.ActualizarClientePort;
import com.devsu.cliente.exception.ClienteException;
import org.springframework.stereotype.Service;

@Service
class ActualizarClienteService implements ActualizarClienteUseCase {

    private final ActualizarClientePort actualizarClientePort;

    ActualizarClienteService(ActualizarClientePort actualizarClientePort) {
        this.actualizarClientePort = actualizarClientePort;
    }

    @Override
    public ClienteDto guardarCliente(NuevoClienteCommand command) throws ClienteException {
        command.validar();
        return actualizarClientePort.guardarCliente(command.cliente());
    }

    @Override
    public ClienteDto actualizarCliente(ClienteCommand command) throws ClienteException {
        command.validar();
        return actualizarClientePort.actualizarCliente(command.identificacion(), command.cliente());
    }

    @Override
    public void eliminarCliente(IdentificacionCommand command) throws ClienteException {
        command.validar();
        actualizarClientePort.eliminarCliente(command.identificacion());
    }

}
