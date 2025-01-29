package com.business.report.expe.controller;

import com.business.report.expe.model.Irut0802Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut0802Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut0802")
public class Irut0802Controller {

    private final Irut0802Service irut0802Service;

    public Irut0802Controller(Irut0802Service irut0802Service) {
        this.irut0802Service = irut0802Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Irut0802Response> futureResponse = irut0802Service.consultarRut(request);
            Irut0802Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
