package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Irut1402Response {
    private String[] errors;
    private boolean success;
    private MultasBancoCentralData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MultasBancoCentralData {
        private String retcode;
        private String retdesc;
        private String idtrx;
        private Resumen resumen;
        private Detalle detalle;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Resumen {
        private String totalMultas;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detalle {
        private List<Multa> multa;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Multa {
        private String fechaCircular;
        private String glosa;
        private String tipoMoneda;
        private String monto;
        private String numeroCircular;
        private String numeroInfraccion;
    }
}
