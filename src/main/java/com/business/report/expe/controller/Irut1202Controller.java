package com.business.report.expe.controller;

import com.business.report.expe.model.Irut1202Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut1202Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut1202")
public class Irut1202Controller {

    private final Irut1202Service irut1202Service;

    public Irut1202Controller(Irut1202Service irut1202Service) {
        this.irut1202Service = irut1202Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Irut1202Response> futureResponse = irut1202Service.consultarRut(request);
            Irut1202Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
