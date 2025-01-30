package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class RutRequest {
    private String rut;
    @JsonAlias("temporalidad")
    private String temporalidad; // Nuevo campo agregado
}
