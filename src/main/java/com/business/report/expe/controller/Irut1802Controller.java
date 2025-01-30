package com.business.report.expe.controller;

import com.business.report.expe.model.Irut1802Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut1802Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut1802")
public class Irut1802Controller {

    private final Irut1802Service irut1802Service;

    public Irut1802Controller(Irut1802Service irut1802Service) {
        this.irut1802Service = irut1802Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Irut1802Response> futureResponse = irut1802Service.consultarRut(request);
            Irut1802Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

            if (response != null) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(503).body("Servicio no disponible, intente más tarde.");
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            return ResponseEntity.status(500).body("Error al procesar la solicitud: " + e.getMessage());
        }
    }
}
