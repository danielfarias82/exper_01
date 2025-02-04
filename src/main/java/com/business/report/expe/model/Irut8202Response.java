package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

@Data
public class Irut8202Response {
    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("ExisteDetalle")
    private String existeDetalle;

    @JsonAlias("NumChqProtest")
    private String numChqProtest;

    @JsonAlias("NumLtrProtest")
    private String numLtrProtest;

    @JsonAlias("NumPagProtest")
    private String numPagProtest;

    @JsonAlias("NumOtrDocProtest")
    private String numOtrDocProtest;

    @JsonAlias("TotalProtestos")
    private String totalProtestos;

    @JsonAlias("Detalles")
    private List<Irut8202Detalle> detalles;
}

@Data
class Irut8202Detalle {
    @JsonAlias("NumBolCom")
    private String numBolCom;

    @JsonAlias("PagBolCom")
    private String pagBolCom;

    @JsonAlias("FecBolCom")
    private String fecBolCom;

    @JsonAlias("FecDeVenc")
    private String fecDeVenc;

    @JsonAlias("TipoDeDoc")
    private String tipoDeDoc;

    @JsonAlias("TipoDeMoneda")
    private String tipoDeMoneda;

    @JsonAlias("Monto")
    private String monto;

    @JsonAlias("Motivo")
    private String motivo;

    @JsonAlias("Localidad")
    private String localidad;

    @JsonAlias("Notaria")
    private String notaria;

    @JsonAlias("NumDeOperacion")
    private String numDeOperacion;

    @JsonAlias("BancoOLiberador")
    private String bancoOLiberador;
}
