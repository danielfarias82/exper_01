package com.business.report.expe.model.sncr;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Sncr0501Response {
    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("ExisteProtestoaPublicar")
    private String existeProtestoaPublicar;

    @JsonAlias("FechaValidezdeDatos")
    private String fechaValidezDeDatos;

    @JsonAlias("MontoenPesos")
    private String montoEnPesos;

    @JsonAlias("Nombre")
    private String nombre;
}
