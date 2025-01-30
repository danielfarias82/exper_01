package com.business.report.expe.model.sncr;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Sncr3501Response {
    @JsonAlias("CodigoRetorno")
    private String codigoRetorno;

    @JsonAlias("IndicadordeDetalle")
    private String indicadorDeDetalle;

    @JsonAlias("TotaldePublicSocio")
    private String totalDePublicSocio;

    @JsonAlias("TotaldePublicSociedad")
    private String totalDePublicSociedad;

    @JsonAlias("NumeroTotaldePublic")
    private String numeroTotalDePublic;

    @JsonAlias("NumeroPublicaSocioenConst")
    private String numeroPublicaSocioenConst;

    @JsonAlias("NumeroPublicaSocioenModif")
    private String numeroPublicaSocioenModif;

    @JsonAlias("NumeroPublicaSociedadenConst")
    private String numeroPublicaSociedadenConst;

    @JsonAlias("NumeroPublicaSociedadenModif")
    private String numeroPublicaSociedadenModif;

    @JsonAlias("ExisteUltimoExtracto")
    private String existeUltimoExtracto;
}
