package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

import lombok.Data;

@Data
public class Irut0202Response {

    private List<String> errors;
    private boolean success;
    private Irut0202ResponseData data;
}

@Data
class Irut0202ResponseData {
    @JsonAlias("CodigoRetorno")
    private String CodigoRetorno;
    @JsonAlias("ExisteDetalle")
    private String ExisteDetalle;
    @JsonAlias("NumAcreedores")
    private String NumAcreedores;
    @JsonAlias("TotalDocImpago")
    private String TotalDocImpago;

}
