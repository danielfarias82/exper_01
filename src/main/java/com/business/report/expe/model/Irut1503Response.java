package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

@Data
public class Irut1503Response {

    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("IndicadordeDetalle")
    private String indicadorDeDetalle;

    @JsonAlias("MontoDeudaPeriodoUf")
    private String montoDeudaPeriodoUf;

    @JsonAlias("FechaUltimoPerido")
    private String fechaUltimoPeriodo;

    @JsonAlias("NumeroRegistrosDetalleDetalle")
    private String numeroRegistrosDetalleDetalle;

    @JsonAlias("Detalles")
    private List<Detalle> detalles;

    @JsonAlias("DetallesdelDetalles")
    private Object detallesDelDetalles; // Puede ser `null` según el ejemplo proporcionado

    @Data
    public static class Detalle {
        @JsonAlias("PeridodelaInformacion")
        private String periodoDeLaInformacion;

        @JsonAlias("NumeroAcreedores")
        private String numeroAcreedores;

        @JsonAlias("PlazoPromedio")
        private String plazoPromedio;

        @JsonAlias("DeudaDirectaVigente")
        private String deudaDirectaVigente;

        @JsonAlias("DeudaDirectaMorosa")
        private String deudaDirectaMorosa;

        @JsonAlias("DeudaDirectaVencida")
        private String deudaDirectaVencida;

        @JsonAlias("DeudaDirectaCastigada")
        private String deudaDirectaCastigada;

        @JsonAlias("DeudaIndirectaVigente")
        private String deudaIndirectaVigente;

        @JsonAlias("DeudaIndirectaMorosa")
        private String deudaIndirectaMorosa;

        @JsonAlias("DeudaIndirectaVencida")
        private String deudaIndirectaVencida;

        @JsonAlias("DeudaIndirectaCastigada")
        private String deudaIndirectaCastigada;
    }
}
