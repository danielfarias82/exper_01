package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

@Data
public class Irut1603Response {

    @JsonAlias("CodigoRetorno")
    private int codigoRetorno;

    @JsonAlias("Resumen")
    private Resumen resumen;

    @JsonAlias("Detalle")
    private List<Detalle> detalle;

    @Data
    public static class Resumen {
        @JsonAlias({ "ExisteDetalle", "existe_detalle" })
        private String existeDetalle;

        @JsonAlias({ "AñoMesDeuda", "ano_mes_deuda" })
        private String añoMesDeuda;

        @JsonAlias({ "DeudaTotal", "deuda_total" })
        private String deudaTotal;

        @JsonAlias({ "NombreSuperIntendencia", "nombre_superintendencia" })
        private String nombreSuperIntendencia;
    }

    @Data
    public static class Detalle {
        @JsonAlias({ "AñoMesDeuda", "ano_mes_deuda" })
        private String añoMesDeuda;

        @JsonAlias({ "DeudaDirectaVig", "deuda_directa_vig" })
        private String deudaDirectaVig;

        @JsonAlias({ "DeudaxInversFinan", "deuda_x_invers_finan" })
        private String deudaXInversFinan;

        @JsonAlias({ "DeudaVencDirecta", "deuda_venc_directa" })
        private String deudaVencDirecta;

        @JsonAlias({ "DeudaxOperConPacto", "deuda_x_oper_con_pacto" })
        private String deudaXOperConPacto;

        @JsonAlias({ "DeudaIndirectaVig", "deuda_indirecta_vig" })
        private String deudaIndirectaVig;

        @JsonAlias({ "DeudaIndirectaVenc", "deuda_indirecta_venc" })
        private String deudaIndirectaVenc;

        @JsonAlias({ "DeudaComercial", "deuda_comercial" })
        private String deudaComercial;

        @JsonAlias({ "DeudaxCredConsu", "deuda_x_cred_consu" })
        private String deudaXCredConsu;

        @JsonAlias({ "NumAcreexCredConsu", "num_acreex_cred_consu" })
        private String numAcreexCredConsu;

        @JsonAlias({ "DeudaxCredHipo", "deuda_x_cred_hipo" })
        private String deudaXCredHipo;

        @JsonAlias({ "DeudaMorosa", "deuda_morosa" })
        private String deudaMorosa;

        @JsonAlias({ "DeudaCastigDirecta", "deuda_castig_directa" })
        private String deudaCastigDirecta;

        @JsonAlias({ "DeudaCastigIndirecta", "deuda_castig_indirecta" })
        private String deudaCastigIndirecta;

        @JsonAlias({ "MtoLineaCredDisp", "mto_linea_cred_disp" })
        private String mtoLineaCredDisp;

        @JsonAlias({ "DeudaComVigMEx", "deuda_com_vig_mex" })
        private String deudaComVigMEx;

        @JsonAlias({ "DeudaComVencMEx", "deuda_com_venc_mex" })
        private String deudaComVencMEx;
    }
}
