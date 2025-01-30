package com.business.report.expe.controller.sncr;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr3302Response;
import com.business.report.expe.service.sncr.Sncr3302Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/sncr3302")
public class Sncr3302Controller {

    private final Sncr3302Service sncr3302Service;

    public Sncr3302Controller(Sncr3302Service sncr3302Service) {
        this.sncr3302Service = sncr3302Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Sncr3302Response> futureResponse = sncr3302Service.consultarRut(request);
            Sncr3302Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
