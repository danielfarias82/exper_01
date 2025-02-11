package com.business.report.expe.model.sncr;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sncr1401Response {
    private boolean success;
    private String[] errors;
    private PeriodosDeudaData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PeriodosDeudaData {
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
        @JsonAlias("nombreCompleto")
        private String nombreCompleto;
        @JsonAlias("fechaCorte")
        private String fechaCorte;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detalle {
        @JsonAlias("deuda")
        private List<Deuda> deuda;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Deuda {
        @JsonAlias("numeroPeriodo")
        private String numeroPeriodo;
        @JsonAlias("fechaPeriodo")
        private String fechaPeriodo;
        @JsonAlias("deudaDeudorVigente")
        private String deudaDeudorVigente;
        @JsonAlias("deudaDeudorPeriodo1")
        private String deudaDeudorPeriodo1;
        @JsonAlias("deudaDeudorPeriodo2")
        private String deudaDeudorPeriodo2;
        @JsonAlias("deudaDeudorPeriodo3")
        private String deudaDeudorPeriodo3;
        @JsonAlias("deudaDeudorPeriodo4")
        private String deudaDeudorPeriodo4;
        @JsonAlias("deudaDeudorTotal")
        private String deudaDeudorTotal;
        @JsonAlias("deudaClienteVigente")
        private String deudaClienteVigente;
        @JsonAlias("deudaClientePeriodo1")
        private String deudaClientePeriodo1;
        @JsonAlias("deudaClientePeriodo2")
        private String deudaClientePeriodo2;
        @JsonAlias("deudaClientePeriodo3")
        private String deudaClientePeriodo3;
        @JsonAlias("deudaClientePeriodo4")
        private String deudaClientePeriodo4;
        @JsonAlias("deudaClienteTotal")
        private String deudaClienteTotal;
        @JsonAlias("institucionesClienteTotal")
        private String institucionesClienteTotal;
        @JsonAlias("sumaInstitucionesCliente")
        private String sumaInstitucionesCliente;
        @JsonAlias("institucionesDeudorTotal")
        private String institucionesDeudorTotal;
    }
}
