package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

@Data
public class Irut0702Response {

    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("Resumen")
    private Resumen resumen;

    @JsonAlias("Detalle")
    private List<Detalle> detalle;

    @Data
    public static class Resumen {
        @JsonAlias("ExisteDetalle")
        private String existeDetalle;

        @JsonAlias("NumDeudaPrevi")
        private String numDeudaPrevi;

        @JsonAlias("NumeroMultas")
        private String numeroMultas;
    }

    @Data
    public static class Detalle {
        @JsonAlias("NumBOLComercial")
        private String numBOLComercial;

        @JsonAlias("PagBOLComercial")
        private String pagBOLComercial;

        @JsonAlias("FechaBOLComercial")
        private String fechaBOLComercial;

        @JsonAlias("TipoInfraccion")
        private String tipoInfraccion;

        @JsonAlias("NumMesesAdeudados")
        private String numMesesAdeudados;

        @JsonAlias("MontoDeudaImpos")
        private String montoDeudaImpos;

        @JsonAlias("RegionInspTrabajo")
        private String regionInspTrabajo;

        @JsonAlias("NumInspTrabajo")
        private String numInspTrabajo;

        @JsonAlias("AñoResolucion")
        private String añoResolucion;

        @JsonAlias("NumResolucion")
        private String numResolucion;

        @JsonAlias("MotivoInfraccion")
        private String motivoInfraccion;

        @JsonAlias("NombreAFP")
        private String nombreAFP;
    }
}
