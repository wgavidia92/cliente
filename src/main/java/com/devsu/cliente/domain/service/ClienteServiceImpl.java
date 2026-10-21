package com.devsu.cliente.domain.service;

import com.devsu.cliente.domain.exception.ClienteException;
import com.devsu.cliente.domain.model.Cliente;
import com.devsu.cliente.domain.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

    static final String ERROR_CLIENTE_NO_ENCONTRADO = "Cliente no encontrado";
    static final String ERROR_ACTUALIZANDO_INFORMACION = "Error actualizando la informacion del cliente";

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findBy(String identificacion) throws ClienteException {
        return clienteRepository.findByIdentificacion(identificacion)
                .orElseThrow(() -> new ClienteException(ERROR_CLIENTE_NO_ENCONTRADO));
    }

    @Override
    public Cliente save(Cliente cliente) throws ClienteException {
        try {
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            throw new ClienteException(ERROR_ACTUALIZANDO_INFORMACION);
        }
    }

    @Override
    public Cliente update(String identificacion, Cliente cliente) throws ClienteException {
        try {
            var clienteExistenteOpt = clienteRepository.findByIdentificacion(identificacion);
            if (clienteExistenteOpt.isEmpty()) {
                log.error(ERROR_CLIENTE_NO_ENCONTRADO);
                throw new ClienteException(ERROR_ACTUALIZANDO_INFORMACION);
            }

            var clienteExistente = clienteExistenteOpt.get();

            var clienteActualizado = new Cliente(
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

            return clienteRepository.save(clienteActualizado);
        } catch (ClienteException e) {
            throw e;
        } catch (Exception e) {
            throw new ClienteException(ERROR_ACTUALIZANDO_INFORMACION);
        }
    }

    @Override
    public void deleteBy(String identificacion) throws ClienteException {
        try {
            var clienteExistenteOpt = clienteRepository.findByIdentificacion(identificacion);
            if (clienteExistenteOpt.isEmpty()) {
                log.error(ERROR_CLIENTE_NO_ENCONTRADO);
                throw new ClienteException(ERROR_ACTUALIZANDO_INFORMACION);
            }

            clienteRepository.delete(clienteExistenteOpt.get());
        } catch (ClienteException e) {
            throw e;
        } catch (Exception e) {
            throw new ClienteException(ERROR_ACTUALIZANDO_INFORMACION);
        }
    }

}
