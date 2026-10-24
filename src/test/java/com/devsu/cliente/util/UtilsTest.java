package com.devsu.cliente.util;

import com.devsu.cliente.application.domain.model.ClienteDto;

public class UtilsTest {

    private UtilsTest() {
    }

    public static ClienteDto generarCliente() {
        return new ClienteDto(
                1L,
                "",
                "",
                "",
                1,
                "",
                "",
                "",
                true);
    }

}
