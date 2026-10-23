package com.devsu.cliente.application.domain.model;

public record ClienteDto(
        Long clienteId,
        String identificacion,
        String nombre,
        String genero,
        int edad,
        String direccion,
        String telefono,
        String contrasena,
        String estado
) {
}
