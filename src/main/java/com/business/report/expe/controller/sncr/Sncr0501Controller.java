package com.business.report.expe.controller.sncr;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr0501Response;
import com.business.report.expe.service.sncr.Sncr0501Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/sncr0501")
public class Sncr0501Controller {

    private final Sncr0501Service sncr0501Service;

    public Sncr0501Controller(Sncr0501Service sncr0501Service) {
        this.sncr0501Service = sncr0501Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Sncr0501Response> futureResponse = sncr0501Service.consultarRut(request);
            Sncr0501Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
