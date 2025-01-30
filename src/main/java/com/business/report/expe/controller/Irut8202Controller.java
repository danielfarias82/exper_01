package com.business.report.expe.controller;

import com.business.report.expe.model.Irut8202Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut8202Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut8202")
public class Irut8202Controller {

    private final Irut8202Service irut8202Service;

    public Irut8202Controller(Irut8202Service irut8202Service) {
        this.irut8202Service = irut8202Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Irut8202Response> futureResponse = irut8202Service.consultarRut(request);
            Irut8202Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
