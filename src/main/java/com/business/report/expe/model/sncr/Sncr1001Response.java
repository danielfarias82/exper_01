package com.business.report.expe.model.sncr;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Sncr1001Response {
    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("ExisteDetalle")
    private String existeDetalle;

    @JsonAlias("NumeroConsMesActual")
    private String numeroConsMesActual;

    @JsonAlias("NumeroConsPenultimoMes")
    private String numeroConsPenultimoMes;

    @JsonAlias("NumeroConsAntepenultimoMes")
    private String numeroConsAntepenultimoMes;

    @JsonAlias("NumeroConsMesAnteriorAntepenultimo")
    private String numeroConsMesAnteriorAntepenultimo;

    @JsonAlias("TotalConsultas")
    private String totalConsultas;
}
