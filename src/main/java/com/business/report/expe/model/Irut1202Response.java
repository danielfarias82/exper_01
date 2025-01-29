package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Irut1202Response {

    @JsonAlias("CodigoRetorno")
    private int codigoRetorno;

    @JsonAlias("Resumen")
    private Resumen resumen;

    @Data
    public static class Resumen {
        @JsonAlias("ExisteDetalle")
        private String existeDetalle;

        @JsonAlias("NumCHProtestados")
        private String numCHProtestados;

        @JsonAlias("NumLTProtestados")
        private String numLTProtestados;

        @JsonAlias("NumPGProtestados")
        private String numPGProtestados;

        @JsonAlias("NumOtrosProtestos")
        private String numOtrosProtestos;

        @JsonAlias("TotalProtestos")
        private String totalProtestos;
    }
}
