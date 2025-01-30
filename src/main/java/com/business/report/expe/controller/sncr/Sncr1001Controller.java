package com.business.report.expe.controller.sncr;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr1001Response;
import com.business.report.expe.service.sncr.Sncr1001Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/sncr1001")
public class Sncr1001Controller {

    private final Sncr1001Service sncr1001Service;

    public Sncr1001Controller(Sncr1001Service sncr1001Service) {
        this.sncr1001Service = sncr1001Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Sncr1001Response> futureResponse = sncr1001Service.consultarRut(request);
            Sncr1001Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
