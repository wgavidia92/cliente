package com.devsu.cliente.application.port.out;

import com.devsu.cliente.application.domain.model.ClienteDto;
import com.devsu.cliente.exception.ClienteException;

public interface ActualizarClientePort {

    ClienteDto guardarCliente(ClienteDto cliente) throws ClienteException;

    ClienteDto actualizarCliente(String identificacion, ClienteDto cliente) throws ClienteException;

    void eliminarCliente(String identificacion) throws ClienteException;

}
