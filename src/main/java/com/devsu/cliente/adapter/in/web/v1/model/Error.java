package com.devsu.cliente.adapter.in.web.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Error
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-23T23:30:45.689941-05:00[America/Bogota]", comments = "Generator version: 7.26.0")
public class Error {

    private String codigo;

    private String mensaje;

    public Error() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public Error(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public Error codigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    /**
     * Get codigo
     *
     * @return codigo
     */
    @NotNull
    @Schema(name = "codigo", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("codigo")
    public String getCodigo() {
        return codigo;
    }

    @JsonProperty("codigo")
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Error mensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    /**
     * Get mensaje
     *
     * @return mensaje
     */
    @NotNull
    @Schema(name = "mensaje", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("mensaje")
    public String getMensaje() {
        return mensaje;
    }

    @JsonProperty("mensaje")
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Error error = (Error) o;
        return Objects.equals(this.codigo, error.codigo) &&
                Objects.equals(this.mensaje, error.mensaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, mensaje);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Error {\n");
        sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
        sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
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

