package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

@Data
public class Irut3201Response {
    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("ExisteDetalle")
    private String existeDetalle;

    @JsonAlias("NumerodePropiedades")
    private String numeroDePropiedades;

    @JsonAlias("Detalles")
    private List<Irut3201Detalle> detalles;
}

@Data
class Irut3201Detalle {
    @JsonAlias("NumerodeRol")
    private NumeroRol numeroRol;

    @JsonAlias("Comuna")
    private String comuna;

    @JsonAlias("Direccion")
    private String direccion;

    @JsonAlias("TipodePropiedad")
    private String tipoPropiedad;

    @JsonAlias("Destino")
    private String destino;

    @JsonAlias("Avaluo")
    private String avaluo;
}

@Data
class NumeroRol {
    @JsonAlias("Manzana")
    private String manzana;

    @JsonAlias("Predio")
    private String predio;
}
