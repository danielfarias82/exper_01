package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

@Data
public class Irut0802Response {

    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("ExisteDetalle")
    private String existeDetalle;

    @JsonAlias("TotalPrendas")
    private String totalPrendas;

    @JsonAlias("Detalles")
    private List<Detalle> detalles;

    @Data
    public static class Detalle {
        @JsonAlias("FechaDiarioOficial")
        private String fechaDiarioOficial;

        @JsonAlias("Cuerpo")
        private String cuerpo;

        @JsonAlias("Pagina")
        private String pagina;

        @JsonAlias("Extracto")
        private String extracto;

        @JsonAlias("RutdelAcreedor")
        private String rutDelAcreedor;

        @JsonAlias("NombredelAcreedor")
        private String nombreDelAcreedor;

        @JsonAlias("RutdelNotario")
        private String rutDelNotario;

        @JsonAlias("NombredelNotario")
        private String nombreDelNotario;
    }
}
