package com.business.report.expe.controller;

import com.business.report.expe.model.Irut0202Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut0202Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut0202")
public class Irut0202Controller {

    private final Irut0202Service irut0202Service;

    public Irut0202Controller(Irut0202Service irut0202Service) {
        this.irut0202Service = irut0202Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Irut0202Response> futureResponse = irut0202Service.consultarRut(request);
            Irut0202Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
