package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

@Data
public class Irut0502Response {

    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("ExisteDetalle")
    private String existeDetalle;

    @JsonAlias("TotaldeMovimientos")
    private String totalMovimientos;

    @JsonAlias("Detalles")
    private List<Detalle> detalles;

    @Data
    public static class Detalle {
        @JsonAlias("DomiciliodelFallido")
        private String domicilioDelFallido;

        @JsonAlias("GirodelFallido")
        private String giroDelFallido;

        @JsonAlias("JuzgadooTribunal")
        private String juzgadoOTribunal;

        @JsonAlias("SindicoTitular")
        private String sindicoTitular;

        @JsonAlias("SindicoSuplente")
        private String sindicoSuplente;

        @JsonAlias("FechaDiarioOficial")
        private String fechaDiarioOficial;

        @JsonAlias("Pagina")
        private String pagina;

        @JsonAlias("Extracto")
        private String extracto;

        @JsonAlias("Resolucion")
        private String resolucion;

        @JsonAlias("FechadeResolucion")
        private String fechaDeResolucion;

        @JsonAlias("QuiebraTerminada")
        private String quiebraTerminada;

        @JsonAlias("FechaJuntadeAcreedores")
        private String fechaJuntaDeAcreedores;
    }
}
