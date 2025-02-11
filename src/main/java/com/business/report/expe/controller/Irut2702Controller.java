package com.business.report.expe.controller;

import com.business.report.expe.model.Irut2702Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut2702Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut2702")
public class Irut2702Controller {

    private final Irut2702Service irut2702Service;

    public Irut2702Controller(Irut2702Service irut2702Service) {
        this.irut2702Service = irut2702Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Irut2702Response> consultarRut(@RequestBody RutRequest request)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Irut2702Response> response = irut2702Service.consultarRut(request);
        return ResponseEntity.ok(response.get());
    }
}
