package com.business.report.expe.model.sncr;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Sncr3302Response {
    @JsonAlias("RETCODE")
    private String retCode;

    @JsonAlias("RETDESC")
    private String retDesc;

    @JsonAlias("IDTRX")
    private String idTrx;

    @JsonAlias("DETALLE")
    private Sncr3302Detalle detalle;

    @Data
    public static class Sncr3302Detalle {
        @JsonAlias("ID_CONJUNTO")
        private String idConjunto;

        @JsonAlias("RUT")
        private String rut;

        @JsonAlias("DIGITO")
        private String digito;

        @JsonAlias("RESULTADO_VECTOR")
        private String resultadoVector;

        @JsonAlias("PUNTAJE_SCORING")
        private String puntajeScoring;

        @JsonAlias("PERCENTIL")
        private String percentil;

        @JsonAlias("PROBABILIDAD_NO_PAGO")
        private String probabilidadNoPago;

        @JsonAlias("GRUPO_RIESGO")
        private String grupoRiesgo;

        @JsonAlias("PUNTAJE_MIN_GRUPO")
        private String puntajeMinGrupo;

        @JsonAlias("PUNTAJE_MAX_GRUPO")
        private String puntajeMaxGrupo;

        @JsonAlias("PROBABILIDAD_NO_PAGO_GRUPO")
        private String probabilidadNoPagoGrupo;

        @JsonAlias("PORCENTAJE_POBLACION_GRUPO")
        private String porcentajePoblacionGrupo;

        @JsonAlias("GLOSA_RESULTADO")
        private String glosaResultado;

        @JsonAlias("GLOSA_PUNTAJE")
        private String glosaPuntaje;

        @JsonAlias("GLOSA_PERCENTIL")
        private String glosaPercentil;
    }
}
