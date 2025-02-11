package com.business.report.expe.controller;

import com.business.report.expe.model.Irut1402Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut1402Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut1402")
public class Irut1402Controller {

    private final Irut1402Service irut1402Service;

    public Irut1402Controller(Irut1402Service irut1402Service) {
        this.irut1402Service = irut1402Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Irut1402Response> consultarRut(@RequestBody RutRequest request)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Irut1402Response> response = irut1402Service.consultarRut(request);
        return ResponseEntity.ok(response.get());
    }
}
