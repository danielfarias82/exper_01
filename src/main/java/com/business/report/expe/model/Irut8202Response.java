package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Irut8202Response {
    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("ExisteDetalle")
    private String existeDetalle;

    @JsonAlias("NumChqProtest")
    private String numChqProtest;

    @JsonAlias("NumLtrProtest")
    private String numLtrProtest;

    @JsonAlias("NumPagProtest")
    private String numPagProtest;

    @JsonAlias("NumOtrDocProtest")
    private String numOtrDocProtest;

    @JsonAlias("TotalProtestos")
    private String totalProtestos;
}
