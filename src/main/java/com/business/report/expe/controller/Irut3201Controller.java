package com.business.report.expe.controller;

import com.business.report.expe.model.Irut3201Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut3201Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut3201")
public class Irut3201Controller {

    private final Irut3201Service irut3201Service;

    public Irut3201Controller(Irut3201Service irut3201Service) {
        this.irut3201Service = irut3201Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Irut3201Response> futureResponse = irut3201Service.consultarRut(request);
            Irut3201Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
