package com.devsu.cliente.adapter.out.persistance;

import com.devsu.cliente.application.domain.model.ClienteDto;
import com.devsu.cliente.application.port.out.ActualizarClientePort;
import com.devsu.cliente.application.port.out.ObtenerClientePort;
import com.devsu.cliente.exception.ClienteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class ClienteAdapter implements ActualizarClientePort, ObtenerClientePort {

    static final String ERROR_CLIENTE_NO_ENCONTRADO = "Cliente no encontrado";
    static final String ERROR_ACTUALIZANDO_INFORMACION = "Error actualizando la informacion del cliente";

    private final Logger log;
    private final ClienteRepository clienteRepository;

    public ClienteAdapter(ClienteRepository clienteRepository) {
        this.log = LoggerFactory.getLogger(ClienteAdapter.class);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Optional<ClienteDto> obtenerClientePorIdentificacion(String identificacion) {
        return clienteRepository.findByIdentificacion(identificacion)
                .map(this::from);
    }

    @Override
    public List<ClienteDto> obtenerClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(this::from)
                .toList();
    }

    @Override
    public ClienteDto guardarCliente(ClienteDto cliente) {
        var nuevoCliente = from(cliente);
        var clienteGuardado = clienteRepository.save(nuevoCliente);
        return from(clienteGuardado);
    }

    @Override
    public ClienteDto actualizarCliente(String identificacion, ClienteDto cliente) throws ClienteException {
        var clienteExistenteOpt = clienteRepository.findByIdentificacion(identificacion);
        if (clienteExistenteOpt.isEmpty()) {
            log.error(ERROR_CLIENTE_NO_ENCONTRADO);
            throw new ClienteException(ERROR_ACTUALIZANDO_INFORMACION);
        }

        var clienteExistente = clienteExistenteOpt.get();

        var clienteActualizado = new ClienteEntity(
                clienteExistente.clienteId(),
                identificacion,
                cliente.nombre(),
                cliente.genero(),
                cliente.edad(),
                cliente.direccion(),
                cliente.telefono(),
                cliente.contrasena(),
                cliente.estado()
        );

        var clienteActualizadoDB = clienteRepository.save(clienteActualizado);
        return from(clienteActualizadoDB);
    }

    @Override
    public void eliminarCliente(String identificacion) throws ClienteException {
        var clienteExistenteOpt = clienteRepository.findByIdentificacion(identificacion);
        if (clienteExistenteOpt.isEmpty()) {
            log.error(ERROR_CLIENTE_NO_ENCONTRADO);
            throw new ClienteException(ERROR_ACTUALIZANDO_INFORMACION);
        }

        clienteRepository.delete(clienteExistenteOpt.get());
    }

    private ClienteDto from(ClienteEntity entity) {
        return new ClienteDto(
                entity.clienteId(),
                entity.identificacion(),
                entity.nombre(),
                entity.genero(),
                entity.edad(),
                entity.direccion(),
                entity.telefono(),
                entity.contrasena(),
                entity.estado()
        );
    }

    private ClienteEntity from(ClienteDto entity) {
        return new ClienteEntity(
                entity.clienteId(),
                entity.identificacion(),
                entity.nombre(),
                entity.genero(),
                entity.edad(),
                entity.direccion(),
                entity.telefono(),
                entity.contrasena(),
                entity.estado()
        );
    }

}
