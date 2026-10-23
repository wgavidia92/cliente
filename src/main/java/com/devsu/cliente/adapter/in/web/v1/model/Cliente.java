package com.devsu.cliente.adapter.in.web.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * Cliente
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-22T22:37:40.528690-05:00[America/Bogota]", comments = "Generator version: 7.26.0")
public class Cliente {

    private Long clienteId;

    private String identificacion;

    private String nombre;

    private String genero;

    private Integer edad;

    private String direccion;

    private String contrasena;

    private String telefono;

    private String estado;

    public Cliente clienteId(Long clienteId) {
        this.clienteId = clienteId;
        return this;
    }

    /**
     * Get clienteId
     *
     * @return clienteId
     */

    @Schema(name = "cliente_id", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("cliente_id")
    public Long getClienteId() {
        return clienteId;
    }

    @JsonProperty("cliente_id")
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Cliente identificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    /**
     * Get identificacion
     *
     * @return identificacion
     */

    @Schema(name = "identificacion", example = "1234", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("identificacion")
    public String getIdentificacion() {
        return identificacion;
    }

    @JsonProperty("identificacion")
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Cliente nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * Get nombre
     *
     * @return nombre
     */

    @Schema(name = "nombre", example = "cliente", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente genero(String genero) {
        this.genero = genero;
        return this;
    }

    /**
     * Get genero
     *
     * @return genero
     */

    @Schema(name = "genero", example = "M", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("genero")
    public String getGenero() {
        return genero;
    }

    @JsonProperty("genero")
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Cliente edad(Integer edad) {
        this.edad = edad;
        return this;
    }

    /**
     * Get edad
     *
     * @return edad
     */

    @Schema(name = "edad", example = "20", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("edad")
    public Integer getEdad() {
        return edad;
    }

    @JsonProperty("edad")
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Cliente direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    /**
     * Get direccion
     *
     * @return direccion
     */

    @Schema(name = "direccion", example = "carrera 1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("direccion")
    public String getDireccion() {
        return direccion;
    }

    @JsonProperty("direccion")
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cliente contrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    /**
     * Get contrasena
     *
     * @return contrasena
     */

    @Schema(name = "contrasena", example = "12345", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("contrasena")
    public String getContrasena() {
        return contrasena;
    }

    @JsonProperty("contrasena")
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Cliente telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    /**
     * Get telefono
     *
     * @return telefono
     */

    @Schema(name = "telefono", example = "12345", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("telefono")
    public String getTelefono() {
        return telefono;
    }

    @JsonProperty("telefono")
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cliente estado(String estado) {
        this.estado = estado;
        return this;
    }

    /**
     * Get estado
     *
     * @return estado
     */

    @Schema(name = "estado", example = "A", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("estado")
    public String getEstado() {
        return estado;
    }

    @JsonProperty("estado")
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(this.clienteId, cliente.clienteId) &&
                Objects.equals(this.identificacion, cliente.identificacion) &&
                Objects.equals(this.nombre, cliente.nombre) &&
                Objects.equals(this.genero, cliente.genero) &&
                Objects.equals(this.edad, cliente.edad) &&
                Objects.equals(this.direccion, cliente.direccion) &&
                Objects.equals(this.contrasena, cliente.contrasena) &&
                Objects.equals(this.telefono, cliente.telefono) &&
                Objects.equals(this.estado, cliente.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, identificacion, nombre, genero, edad, direccion, contrasena, telefono, estado);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Cliente {\n");
        sb.append("    clienteId: ").append(toIndentedString(clienteId)).append("\n");
        sb.append("    identificacion: ").append(toIndentedString(identificacion)).append("\n");
        sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
        sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
        sb.append("    edad: ").append(toIndentedString(edad)).append("\n");
        sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
        sb.append("    contrasena: ").append(toIndentedString(contrasena)).append("\n");
        sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
        sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

