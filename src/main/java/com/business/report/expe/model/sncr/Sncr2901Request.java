package com.business.report.expe.model.sncr;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Sncr2901Request {
    private String rut;
    @JsonAlias("validaNuevos")
    private String validaNuevos;
}
