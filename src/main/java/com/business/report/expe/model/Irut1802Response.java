package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Irut1802Response {
    @JsonAlias("TotalDirecciones")
    private String totalDirecciones;

    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("ExisteDetalle")
    private String existeDetalle;
}
