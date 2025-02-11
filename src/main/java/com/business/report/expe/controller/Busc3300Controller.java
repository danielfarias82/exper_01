package com.business.report.expe.controller;

import com.business.report.expe.model.Busc3300Response;
import com.business.report.expe.model.DescripcionRequest;
import com.business.report.expe.service.Busc3300Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/busc3300")
public class Busc3300Controller {

    private final Busc3300Service busc3300Service;

    public Busc3300Controller(Busc3300Service busc3300Service) {
        this.busc3300Service = busc3300Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Busc3300Response> consultarEmpresa(@RequestBody DescripcionRequest request)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Busc3300Response> response = busc3300Service.consultarEmpresa(request);
        return ResponseEntity.ok(response.get());
    }
}
