package com.devsu.cliente.application.port.in;

import com.devsu.cliente.application.domain.model.ClienteDto;
import com.devsu.cliente.exception.ClienteException;
import org.springframework.util.StringUtils;

import java.util.List;

public interface ObtenerClienteUseCase {

    static final String ERROR_VALIDACION_IDENTIFICACION = "El numero de identificacion es obligatorio";

    List<ClienteDto> obtenerClientes();

    ClienteDto obtenerClientePorIdentificacion(IdentificacionQuery query) throws ClienteException;

    record IdentificacionQuery(String identificacion) {

        public void validar() throws ClienteException {
            if (!StringUtils.hasText(identificacion))
                throw new ClienteException(ERROR_VALIDACION_IDENTIFICACION);
        }

    }

}
