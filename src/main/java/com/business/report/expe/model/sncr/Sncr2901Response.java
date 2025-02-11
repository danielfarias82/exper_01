package com.business.report.expe.model.sncr;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sncr2901Response {
    private boolean success;
    private String[] errors;
    private DirectorioPersonaData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DirectorioPersonaData {
        @JsonAlias("retcode")
        private String retcode;
        @JsonAlias("retdesc")
        private String retdesc;
        @JsonAlias("idtrx")
        private String idtrx;
        @JsonAlias("resumen")
        private Resumen resumen;
        @JsonAlias("detalleActividadEconimica")
        private List<DetalleActividadEconomica> detalleActividadEconimica;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Resumen {
        @JsonAlias("idConjuntoResultado")
        private String idConjuntoResultado;
        @JsonAlias("existeDetalle")
        private String existeDetalle;
        @JsonAlias("nombreEncontrado")
        private String nombreEncontrado;
        @JsonAlias("tipoPersona")
        private String tipoPersona;
        @JsonAlias("fechaModificacionNombre")
        private String fechaModificacionNombre;
        @JsonAlias("fuenteNombre")
        private String fuenteNombre;
        @JsonAlias("cantidadActividadEconomica")
        private String cantidadActividadEconomica;
        @JsonAlias("fuenteBanco")
        private String fuenteBanco;
        @JsonAlias("informacionPersonal")
        private InformacionPersonal informacionPersonal;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InformacionPersonal {
        // Natural Person fields
        @JsonAlias("apellidoPaterno")
        private String apellidoPaterno;
        @JsonAlias("apellidoMaterno")
        private String apellidoMaterno;
        @JsonAlias("nombres")
        private String nombres;
        @JsonAlias("fechaNacimiento")
        private String fechaNacimiento;
        @JsonAlias("genero")
        private String genero;
        @JsonAlias("fechaDefuncion")
        private String fechaDefuncion;
        @JsonAlias("codigoNacionalidad")
        private String codigoNacionalidad;
        @JsonAlias("numeroSolicitud")
        private String numeroSolicitud;

        // Legal Entity fields
        @JsonAlias("razonSocial")
        private String razonSocial;
        @JsonAlias("quiebra")
        private String quiebra;
        @JsonAlias("fechaActividadQuiebra")
        private String fechaActividadQuiebra;
        @JsonAlias("sindicoTitular")
        private String sindicoTitular;
        @JsonAlias("sindicoSuplente")
        private String sindicoSuplente;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DetalleActividadEconomica {
        @JsonAlias("idConjuntoResultado")
        private String idConjuntoResultado;
        @JsonAlias("codigoGiro")
        private String codigoGiro;
        @JsonAlias("descripcionGiro")
        private String descripcionGiro;
        @JsonAlias("fuenteGiro")
        private String fuenteGiro;
    }
}
