package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Irut3102Response {
    private String[] errors;
    private boolean success;
    private SituacionesTributariasData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SituacionesTributariasData {
        private String retcode;
        private String retdesc;
        private String idtrx;
        private Resumen resumen;
        private Detalle detalle;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Resumen {
        private String totalRegistros;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detalle {
        private List<SituacionTributaria> situacionTributaria;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SituacionTributaria {
        private String fechaAnotacion;
        private String codigoAnotacion;
        private String descripcion;
        private String folio;
    }
}
