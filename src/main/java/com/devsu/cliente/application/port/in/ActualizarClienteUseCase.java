package com.devsu.cliente.application.port.in;

import com.devsu.cliente.application.domain.model.ClienteDto;
import com.devsu.cliente.exception.ClienteException;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.StringUtils;

public interface ActualizarClienteUseCase {

    static final String ERROR_VALIDACION_DATOS = "Informacion de cliente incompleta";

    ClienteDto guardarCliente(NuevoClienteCommand command) throws ClienteException;

    ClienteDto actualizarCliente(ClienteCommand command) throws ClienteException;

    void eliminarCliente(IdentificacionCommand command) throws ClienteException;

    record IdentificacionCommand(String identificacion) {

        public void validar() throws ClienteException {
            if (!StringUtils.hasText(identificacion))
                throw new ClienteException(ERROR_VALIDACION_DATOS);
        }

    }

    record NuevoClienteCommand(@NotNull ClienteDto cliente) {

        public void validar() throws ClienteException {
            validarDato(cliente.identificacion());
            validarDato(cliente.nombre());
            validarDato(cliente.genero());
            validarDato(cliente.estado());
            validarDato(cliente.contrasena());
        }

        private void validarDato(String dato) throws ClienteException {
            if (!StringUtils.hasText(dato))
                throw new ClienteException(ERROR_VALIDACION_DATOS);
        }

    }

    record ClienteCommand(@NotNull String identificacion, @NotNull ClienteDto cliente) {

        public void validar() throws ClienteException {
            validarDato(identificacion);

            if (cliente.clienteId() == null || cliente.clienteId().compareTo(0L) < 0)
                throw new ClienteException(ERROR_VALIDACION_DATOS);

            validarDato(cliente.nombre());
            validarDato(cliente.genero());
            validarDato(cliente.estado());
            validarDato(cliente.contrasena());
        }

        private void validarDato(String dato) throws ClienteException {
            if (!StringUtils.hasText(dato))
                throw new ClienteException(ERROR_VALIDACION_DATOS);
        }
    }

}
