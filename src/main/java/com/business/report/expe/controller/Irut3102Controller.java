package com.business.report.expe.controller;

import com.business.report.expe.model.Irut3102Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut3102Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/irut3102")
public class Irut3102Controller {

    private final Irut3102Service irut3102Service;

    public Irut3102Controller(Irut3102Service irut3102Service) {
        this.irut3102Service = irut3102Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Irut3102Response> consultarRut(@RequestBody RutRequest request)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Irut3102Response> response = irut3102Service.consultarRut(request);
        return ResponseEntity.ok(response.get());
    }
}
