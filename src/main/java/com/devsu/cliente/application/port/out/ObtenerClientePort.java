package com.devsu.cliente.application.port.out;

import com.devsu.cliente.application.domain.model.ClienteDto;
import com.devsu.cliente.exception.ClienteException;

import java.util.List;
import java.util.Optional;

public interface ObtenerClientePort {

    List<ClienteDto> obtenerClientes();

    Optional<ClienteDto> obtenerClientePorIdentificacion(String identificacion) throws ClienteException;

}
