package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Irut2802Response {
    private String[] errors;
    private boolean success;
    private DomiciliosLaboralesData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DomiciliosLaboralesData {
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
        private String razonSocial;
        private String rubro;
        private String domicilio;
        private String comuna;
        private String ciudad;
        private String fonoLaboral;
        private String ubicacion;
        private String estado;
        private String cargo;
        private String habitaDesde;
        private String tipoContrato;
        private String tipoRenta;
        private String montoRenta;
        private String montoJubilacion;
        private String montoPension;
    }
}
