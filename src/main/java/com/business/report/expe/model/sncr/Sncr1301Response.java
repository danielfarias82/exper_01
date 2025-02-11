package com.business.report.expe.model.sncr;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sncr1301Response {
    private boolean success;
    private String[] errors;
    private DeudasData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeudasData {
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
        @JsonAlias("existeDetalle")
        private String existeDetalle;
        @JsonAlias("nombreCompleto")
        private String nombreCompleto;
        @JsonAlias("fechaCorte")
        private String fechaCorte;
        @JsonAlias("institucionesDeudorVigente")
        private String institucionesDeudorVigente;
        @JsonAlias("deudaDeudorVigenteFactura")
        private String deudaDeudorVigenteFactura;
        @JsonAlias("deudaDeudorVigenteCheque")
        private String deudaDeudorVigenteCheque;
        @JsonAlias("deudaDeudorVigenteLetra")
        private String deudaDeudorVigenteLetra;
        @JsonAlias("deudaDeudorVigenteOtros")
        private String deudaDeudorVigenteOtros;
        @JsonAlias("deudaTotal")
        private String deudaTotal;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detalle {
        @JsonAlias("deudaTotalDeudor")
        private DeudaTotalDeudor deudaTotalDeudor;
        @JsonAlias("sumaDeudaDeudor")
        private SumaDeudaDeudor sumaDeudaDeudor;
        @JsonAlias("deudaVigenteCliente")
        private DeudaVigenteCliente deudaVigenteCliente;
        @JsonAlias("deudaTotalCliente")
        private DeudaTotalCliente deudaTotalCliente;
        @JsonAlias("sumaDeudaCliente")
        private SumaDeudaCliente sumaDeudaCliente;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeudaTotalDeudor {
        @JsonAlias("institucionesDeudorPeriodo1")
        private String institucionesDeudorPeriodo1;
        @JsonAlias("deudaDeudorFactura1")
        private String deudaDeudorFactura1;
        @JsonAlias("deudaDeudorCheque1")
        private String deudaDeudorCheque1;
        @JsonAlias("deudaDeudorLetra1")
        private String deudaDeudorLetra1;
        @JsonAlias("deudaDeudorOtros1")
        private String deudaDeudorOtros1;
        @JsonAlias("deudaTotal1")
        private String deudaTotal1;
        @JsonAlias("institucionesDeudorPeriodo2")
        private String institucionesDeudorPeriodo2;
        @JsonAlias("deudaDeudorFactura2")
        private String deudaDeudorFactura2;
        @JsonAlias("deudaDeudorCheque2")
        private String deudaDeudorCheque2;
        @JsonAlias("deudaDeudorLetra2")
        private String deudaDeudorLetra2;
        @JsonAlias("deudaDeudorOtros2")
        private String deudaDeudorOtros2;
        @JsonAlias("deudaTotal2")
        private String deudaTotal2;
        @JsonAlias("institucionesDeudorPeriodo3")
        private String institucionesDeudorPeriodo3;
        @JsonAlias("deudaDeudorFactura3")
        private String deudaDeudorFactura3;
        @JsonAlias("deudaDeudorCheque3")
        private String deudaDeudorCheque3;
        @JsonAlias("deudaDeudorLetra3")
        private String deudaDeudorLetra3;
        @JsonAlias("deudaDeudorOtros3")
        private String deudaDeudorOtros3;
        @JsonAlias("deudaTotal3")
        private String deudaTotal3;
        @JsonAlias("institucionesDeudorPeriodo4")
        private String institucionesDeudorPeriodo4;
        @JsonAlias("deudaDeudorFactura4")
        private String deudaDeudorFactura4;
        @JsonAlias("deudaDeudorCheque4")
        private String deudaDeudorCheque4;
        @JsonAlias("deudaDeudorLetra4")
        private String deudaDeudorLetra4;
        @JsonAlias("deudaDeudorOtros4")
        private String deudaDeudorOtros4;
        @JsonAlias("deudaTotal4")
        private String deudaTotal4;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SumaDeudaDeudor {
        @JsonAlias("institucionesDeudorTotal")
        private String institucionesDeudorTotal;
        @JsonAlias("sumaDeudorFactura")
        private String sumaDeudorFactura;
        @JsonAlias("sumaDeudorCheque")
        private String sumaDeudorCheque;
        @JsonAlias("sumaDeudorLetra")
        private String sumaDeudorLetra;
        @JsonAlias("sumaDeudorOtros")
        private String sumaDeudorOtros;
        @JsonAlias("sumaDeudorTotal")
        private String sumaDeudorTotal;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeudaVigenteCliente {
        @JsonAlias("institucionesClienteVigente")
        private String institucionesClienteVigente;
        @JsonAlias("deudaClienteVigenteFactura")
        private String deudaClienteVigenteFactura;
        @JsonAlias("deudaClienteVigenteCheque")
        private String deudaClienteVigenteCheque;
        @JsonAlias("deudaClienteVigenteLetra")
        private String deudaClienteVigenteLetra;
        @JsonAlias("deudaClienteVigenteOtros")
        private String deudaClienteVigenteOtros;
        @JsonAlias("deudaClienteTotal")
        private String deudaClienteTotal;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeudaTotalCliente {
        @JsonAlias("institucionesClientePeriodo1")
        private String institucionesClientePeriodo1;
        @JsonAlias("deudaClienteFactura1")
        private String deudaClienteFactura1;
        @JsonAlias("deudaClienteCheque1")
        private String deudaClienteCheque1;
        @JsonAlias("deudaClienteLetra1")
        private String deudaClienteLetra1;
        @JsonAlias("deudaClienteOtros1")
        private String deudaClienteOtros1;
        @JsonAlias("deudaTotal1")
        private String deudaTotal1;
        @JsonAlias("institucionesClientePeriodo2")
        private String institucionesClientePeriodo2;
        @JsonAlias("deudaClienteFactura2")
        private String deudaClienteFactura2;
        @JsonAlias("deudaClienteCheque2")
        private String deudaClienteCheque2;
        @JsonAlias("deudaClienteLetra2")
        private String deudaClienteLetra2;
        @JsonAlias("deudaClienteOtros2")
        private String deudaClienteOtros2;
        @JsonAlias("deudaTotal2")
        private String deudaTotal2;
        @JsonAlias("institucionesClientePeriodo3")
        private String institucionesClientePeriodo3;
        @JsonAlias("deudaClienteFactura3")
        private String deudaClienteFactura3;
        @JsonAlias("deudaClienteCheque3")
        private String deudaClienteCheque3;
        @JsonAlias("deudaClienteLetra3")
        private String deudaClienteLetra3;
        @JsonAlias("deudaClienteOtros3")
        private String deudaClienteOtros3;
        @JsonAlias("deudaTotal3")
        private String deudaTotal3;
        @JsonAlias("institucionesClientePeriodo4")
        private String institucionesClientePeriodo4;
        @JsonAlias("deudaClienteFactura4")
        private String deudaClienteFactura4;
        @JsonAlias("deudaClienteCheque4")
        private String deudaClienteCheque4;
        @JsonAlias("deudaClienteLetra4")
        private String deudaClienteLetra4;
        @JsonAlias("deudaClienteOtros4")
        private String deudaClienteOtros4;
        @JsonAlias("deudaTotal4")
        private String deudaTotal4;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SumaDeudaCliente {
        @JsonAlias("institucionesClienteTotal")
        private String institucionesClienteTotal;
        @JsonAlias("sumaClienteFactura")
        private String sumaClienteFactura;
        @JsonAlias("sumaClienteCheque")
        private String sumaClienteCheque;
        @JsonAlias("sumaClienteLetra")
        private String sumaClienteLetra;
        @JsonAlias("sumaClienteOtros")
        private String sumaClienteOtros;
        @JsonAlias("sumaClienteTotal")
        private String sumaClienteTotal;
    }
}
