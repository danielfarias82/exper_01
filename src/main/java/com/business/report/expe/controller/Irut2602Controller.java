package com.business.report.expe.controller;

import com.business.report.expe.model.Irut2602Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut2602Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut2602")
public class Irut2602Controller {

    private final Irut2602Service irut2602Service;

    public Irut2602Controller(Irut2602Service irut2602Service) {
        this.irut2602Service = irut2602Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Irut2602Response> consultarRut(@RequestBody RutRequest request)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Irut2602Response> response = irut2602Service.consultarRut(request);
        return ResponseEntity.ok(response.get());
    }
}
