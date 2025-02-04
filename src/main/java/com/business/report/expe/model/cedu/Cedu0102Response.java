package com.business.report.expe.model.cedu;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

@Data
public class Cedu0102Response {
    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("ExisteDetalle")
    private String existeDetalle;

    @JsonAlias("CedulaVigente")
    private String cedulaVigente;

    @JsonAlias("NumeroRegistros")
    private String numeroRegistros;

    @JsonAlias("Detalles")
    private List<Cedu0102Detalle> detalles;

    @Data
    public static class Cedu0102Detalle {
        @JsonAlias("RutConsultado")
        private String rutConsultado;

        @JsonAlias("DigitoVerificador")
        private String digitoVerificador;

        @JsonAlias("TipoDocumento")
        private String tipoDocumento;

        @JsonAlias("NumeroSerie")
        private String numeroSerie;

        @JsonAlias("Razon")
        private String razon;

        @JsonAlias("Fecha")
        private String fecha;

        @JsonAlias("Fuente")
        private String fuente;
    }
}
