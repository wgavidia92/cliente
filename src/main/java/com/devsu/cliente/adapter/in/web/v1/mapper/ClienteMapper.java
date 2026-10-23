package com.devsu.cliente.adapter.in.web.v1.mapper;

import com.devsu.cliente.adapter.in.web.v1.model.Cliente;
import com.devsu.cliente.application.domain.model.ClienteDto;

public class ClienteMapper {

    private ClienteMapper() {
    }

    public static Cliente from(ClienteDto clienteDto) {
        var cliente = new Cliente();
        cliente.setClienteId(clienteDto.clienteId());
        cliente.setIdentificacion(clienteDto.identificacion());
        cliente.setNombre(clienteDto.nombre());
        cliente.setGenero(clienteDto.genero());
        cliente.setEdad(clienteDto.edad());
        cliente.setDireccion(clienteDto.direccion());
        cliente.setTelefono(clienteDto.telefono());
        cliente.setContrasena(clienteDto.contrasena());
        cliente.setEstado(clienteDto.estado());
        return cliente;
    }

    public static ClienteDto from(Cliente cliente) {
        return new ClienteDto(
                cliente.getClienteId(),
                cliente.getIdentificacion(),
                cliente.getNombre(),
                cliente.getGenero(),
                cliente.getEdad(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getContrasena(),
                cliente.getEstado()
        );
    }

}
