package com.business.report.expe.controller;

import com.business.report.expe.model.Irut0702Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut0702Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut0702")
public class Irut0702Controller {

    private final Irut0702Service irut0702Service;

    public Irut0702Controller(Irut0702Service irut0702Service) {
        this.irut0702Service = irut0702Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<?> consultarRut(@RequestBody RutRequest request) {
        try {
            CompletableFuture<Irut0702Response> futureResponse = irut0702Service.consultarRut(request);
            Irut0702Response response = futureResponse.get(); // Esperamos la respuesta del servicio asíncrono

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
