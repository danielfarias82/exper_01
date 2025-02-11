package com.business.report.expe.controller.sncr;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr1401Response;
import com.business.report.expe.service.sncr.Sncr1401Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/sncr1401")
public class Sncr1401Controller {

    private final Sncr1401Service sncr1401Service;

    public Sncr1401Controller(Sncr1401Service sncr1401Service) {
        this.sncr1401Service = sncr1401Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Sncr1401Response> consultarPeriodosDeuda(@RequestBody RutRequest request)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Sncr1401Response> response = sncr1401Service.consultarPeriodosDeuda(request);
        return ResponseEntity.ok(response.get());
    }
}
