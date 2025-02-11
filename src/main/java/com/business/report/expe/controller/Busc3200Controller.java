package com.business.report.expe.controller;

import com.business.report.expe.model.Busc3200Response;
import com.business.report.expe.model.DescripcionRequest;
import com.business.report.expe.service.Busc3200Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/busc3200")
public class Busc3200Controller {

    private final Busc3200Service busc3200Service;

    public Busc3200Controller(Busc3200Service busc3200Service) {
        this.busc3200Service = busc3200Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Busc3200Response> consultarPersona(@RequestBody DescripcionRequest request)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Busc3200Response> response = busc3200Service.consultarPersona(request);
        return ResponseEntity.ok(response.get());
    }
}
