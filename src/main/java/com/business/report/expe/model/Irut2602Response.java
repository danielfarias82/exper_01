package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Irut2602Response {
    private String[] errors;
    private boolean success;
    private DirectorioPersonasData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DirectorioPersonasData {
        private String retcode;
        private String retdesc;
        private String idtrx;
        private Resumen resumen;
        private Detalle detalle;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Resumen {
        private String fechaNacimiento;
        private String fechaDefuncion;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detalle {
        private Directorio directorio;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Directorio {
        private String nombreCompleto;
        private String fechaNacimiento;
        private String actividad;
        private String situacionMilitar;
        private String fechaDefuncion;
        private String edad;
        private String domicilio;
        private String comuna;
        private String ciudad;
        private String nombreRegion;
        private String fechaDireccion;
    }
}
