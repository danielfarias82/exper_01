package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

@Data
public class Irut0202Response {
    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("ExisteDetalle")
    private String existeDetalle;

    @JsonAlias("NumAcreedores")
    private String numAcreedores;

    @JsonAlias("TotalDocImpago")
    private String totalDocImpago;

    @JsonAlias("Detalles")
    private List<Irut0202Detalle> detalles;
}

@Data
class Irut0202Detalle {
    @JsonAlias("TipoDeDoc")
    private String tipoDeDoc;

    @JsonAlias("FecDeVenc")
    private String fecDeVenc;

    @JsonAlias("NombreAportante")
    private String nombreAportante;

    @JsonAlias("TipoDeMoneda")
    private String tipoDeMoneda;

    @JsonAlias("Monto")
    private String monto;

    @JsonAlias("RutDeudorDirecto")
    private String rutDeudorDirecto;

    @JsonAlias("Direccion")
    private String direccion;

    @JsonAlias("Comuna")
    private String comuna;
}
