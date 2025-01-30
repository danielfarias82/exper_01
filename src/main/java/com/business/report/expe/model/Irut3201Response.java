package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Irut3201Response {
    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("ExisteDetalle")
    private String existeDetalle;

    @JsonAlias("NumerodePropiedades")
    private String numeroDePropiedades;
}
