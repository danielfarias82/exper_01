package com.business.report.expe.controller;

import com.business.report.expe.model.Irut1603Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut1603Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut1603")
public class Irut1603Controller {

    private final Irut1603Service irut1603Service;

    public Irut1603Controller(Irut1603Service irut1603Service) {
        this.irut1603Service = irut1603Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Irut1603Response> futureResponse = irut1603Service.consultarRut(request);
            Irut1603Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

            if (response != null) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(503).body("Servicio no disponible, intente más tarde.");
            }
        } catch (ExecutionException e) {
            return ResponseEntity.status(500).body("Error en la ejecución del servicio: " + e.getCause().getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return ResponseEntity.status(500).body("Operación interrumpida, intente nuevamente.");
        }
    }
}
