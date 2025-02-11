package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Irut2702Response {
    private String[] errors;
    private boolean success;
    private DomiciliosParticularesData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DomiciliosParticularesData {
        private String retcode;
        private String retdesc;
        private String idtrx;
        private Resumen resumen;
        private Detalle detalle;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Resumen {
        private String nombreCompleto;
        private String fechaUltimaVerificacion;
        private String totalDomicilios;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detalle {
        private List<Domicilio> domicilio;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Domicilio {
        private String fechaVerificacion;
        private String domicilio;
        private String comuna;
        private String ciudad;
        private String fonoParticular;
        private String ubicacion;
        private String estado;
        private String habitaDesde;
        private String tipoResidencia;
        private String tipoConstruccion;
        private String tipoBarrio;
        private String estadoVivienda;
        private String numeroPisos;
        private String tipoPropiedad;
        private String montoArriendo;
        private String nombreConyuge;
        private String actividadConyuge;
        private String numeroIntegrantes;
        private String numeroOcupados;
        private String numeroJubilados;
    }
}
