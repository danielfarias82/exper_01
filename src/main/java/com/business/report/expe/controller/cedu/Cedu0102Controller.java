package com.business.report.expe.controller.cedu;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.cedu.Cedu0102Response;
import com.business.report.expe.service.cedu.Cedu0102Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/cedu0102")
public class Cedu0102Controller {

    private final Cedu0102Service cedu0102Service;

    public Cedu0102Controller(Cedu0102Service cedu0102Service) {
        this.cedu0102Service = cedu0102Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarCedula(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Cedu0102Response> futureResponse = cedu0102Service.consultarCedula(request);
            Cedu0102Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
