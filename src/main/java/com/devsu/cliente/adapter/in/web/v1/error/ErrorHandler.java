package com.devsu.cliente.adapter.in.web.v1.error;

import com.devsu.cliente.adapter.in.web.v1.model.Error;
import com.devsu.cliente.exception.ClienteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClienteException.class)
    Error clienteException(ClienteException ex) {
        LOGGER.error(ex.getMessage(), ex);
        return new Error()
                .message(ex.getMessage())
                .code("99");
    }

}
