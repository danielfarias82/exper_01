package com.business.report.expe.model.sncr;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sncr1201Response {
    private boolean success;
    private String[] errors;
    private ProtestosData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProtestosData {
        @JsonAlias("retcode")
        private String retcode;
        @JsonAlias("retdesc")
        private String retdesc;
        @JsonAlias("idtrx")
        private String idtrx;
        @JsonAlias("resumen")
        private Resumen resumen;
        @JsonAlias("detalle")
        private Detalle detalle;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Resumen {
        @JsonAlias("totalCheque")
        private String totalCheque;
        @JsonAlias("totalLetra")
        private String totalLetra;
        @JsonAlias("totalPagare")
        private String totalPagare;
        @JsonAlias("totalOtros")
        private String totalOtros;
        @JsonAlias("totalProtestos")
        private String totalProtestos;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detalle {
        @JsonAlias("protestos")
        private List<Protesto> protestos;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Protesto {
        @JsonAlias("boletinProtesto")
        private String boletinProtesto;
        @JsonAlias("paginaProtesto")
        private String paginaProtesto;
        @JsonAlias("fechaBoletin")
        private String fechaBoletin;
        @JsonAlias("fechaProtesto")
        private String fechaProtesto;
        @JsonAlias("tipoDocumento")
        private String tipoDocumento;
        @JsonAlias("tipoMoneda")
        private String tipoMoneda;
        @JsonAlias("monto")
        private String monto;
        @JsonAlias("codigoCausal")
        private String codigoCausal;
        @JsonAlias("localidad")
        private String localidad;
        @JsonAlias("nombreEmisor")
        private String nombreEmisor;
        @JsonAlias("numeroOperacion")
        private String numeroOperacion;
        @JsonAlias("nombreInstitucion")
        private String nombreInstitucion;
    }
}
