package com.business.report.expe.controller;

import com.business.report.expe.model.Irut0502Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut0502Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut0502")
public class Irut0502Controller {

    private final Irut0502Service irut0502Service;

    public Irut0502Controller(Irut0502Service irut0502Service) {
        this.irut0502Service = irut0502Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Irut0502Response> futureResponse = irut0502Service.consultarRut(request);
            Irut0502Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
