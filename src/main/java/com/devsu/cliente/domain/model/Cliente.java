package com.devsu.cliente.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CLIENTE")
public record Cliente(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column("CLIENTE_ID")
        Long clienteId,
        @Column
        String identificacion,
        @Column
        String nombre,
        @Column
        String genero,
        @Column
        int edad,
        @Column
        String direccion,
        @Column
        String telefono,
        @Column
        String contrasena,
        @Column
        String estado
) {

}
