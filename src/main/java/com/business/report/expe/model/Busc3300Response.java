package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Busc3300Response {
    private boolean success;
    private String[] errors;
    private BusquedaEmpresasData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BusquedaEmpresasData {
        @JsonAlias("CodigoRetorno")
        private String codigoRetorno;
        @JsonAlias("ExisteDetalle")
        private String existeDetalle;
        @JsonAlias("NumerodeRegistros")
        private String numerodeRegistros;
        @JsonAlias("Detalles")
        private List<Detalle> detalles;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detalle {
        @JsonAlias("NombredePersona")
        private String nombredePersona;
        @JsonAlias("RutdePersona")
        private String rutdePersona;
        @JsonAlias("PorcentajedeSimilitud")
        private String porcentajedeSimilitud;
    }
}
