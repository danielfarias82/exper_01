package com.business.report.expe.controller;

import com.business.report.expe.model.Irut1503Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut1503Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut1503")
public class Irut1503Controller {

    private final Irut1503Service irut1503Service;

    public Irut1503Controller(Irut1503Service irut1503Service) {
        this.irut1503Service = irut1503Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Irut1503Response> futureResponse = irut1503Service.consultarRut(request);
            Irut1503Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
