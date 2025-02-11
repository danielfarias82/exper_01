package com.business.report.expe.controller;

import com.business.report.expe.model.Irut2802Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut2802Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut2802")
public class Irut2802Controller {

    private final Irut2802Service irut2802Service;

    public Irut2802Controller(Irut2802Service irut2802Service) {
        this.irut2802Service = irut2802Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Irut2802Response> consultarRut(@RequestBody RutRequest request)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Irut2802Response> response = irut2802Service.consultarRut(request);
        return ResponseEntity.ok(response.get());
    }
}
