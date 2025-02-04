package com.business.report.expe.model.sncr;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

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

    @JsonAlias("DetallesConstituciones")
    private List<DetallePublicacion> detallesConstituciones;

    @JsonAlias("DetallesModificaciones")
    private List<DetallePublicacion> detallesModificaciones;

    @JsonAlias("DetallesSociosConstituciones")
    private List<DetalleSocio> detallesSociosConstituciones;

    @JsonAlias("DetallesSociosModificaciones")
    private List<DetalleSocio> detallesSociosModificaciones;

    @JsonAlias("DetallesUltimoExtracto")
    private List<DetalleUltimoExtracto> detallesUltimoExtracto;
}

@Data
class DetallePublicacion {
    @JsonAlias("FechadePublicacion")
    private String fechaDePublicacion;

    @JsonAlias("CuerpoDiarioOficial")
    private String cuerpoDiarioOficial;

    @JsonAlias("PaginaDiarioOficial")
    private String paginaDiarioOficial;

    @JsonAlias("ExtractoDiarioOficial")
    private String extractoDiarioOficial;

    @JsonAlias("NombredeSociedad")
    private String nombreDeSociedad;

    @JsonAlias("Edicion")
    private String edicion;

    @JsonAlias("TipodeSociedad")
    private String tipoDeSociedad;

    @JsonAlias("RutSociedad")
    private String rutSociedad;

    @JsonAlias("DigitoSociedad")
    private String digitoSociedad;

    @JsonAlias("NombredeFantasia")
    private String nombreDeFantasia;

    @JsonAlias("FechaConstitucion")
    private String fechaConstitucion;

    @JsonAlias("CapitalPagado")
    private String capitalPagado;

    @JsonAlias("CapitalSuscrito")
    private String capitalSuscrito;

    @JsonAlias("Moneda")
    private String moneda;

    @JsonAlias("RazonSocialAntigua")
    private String razonSocialAntigua;

    @JsonAlias("TipoSociedadAntigua")
    private String tipoSociedadAntigua;

    @JsonAlias("RegistrodeComercio")
    private String registroDeComercio;

    @JsonAlias("Fojas")
    private String fojas;

    @JsonAlias("Numero")
    private String numero;

    @JsonAlias("Ano")
    private String ano;

    @JsonAlias("Id")
    private String id;

    @JsonAlias("IndicadordeExtracto")
    private String indicadorDeExtracto;

    @JsonAlias("MotivosdePublicacion")
    private String motivosDePublicacion;
}

@Data
class DetalleSocio {
    // Esta clase está vacía ya que en el ejemplo no hay datos,
    // pero la estructura está preparada para futuros campos
}

@Data
class DetalleUltimoExtracto {
    @JsonAlias("Id")
    private String id;

    @JsonAlias("Tipo")
    private String tipo;

    @JsonAlias("Correlativo")
    private String correlativo;

    @JsonAlias("Detalle")
    private String detalle;
}
