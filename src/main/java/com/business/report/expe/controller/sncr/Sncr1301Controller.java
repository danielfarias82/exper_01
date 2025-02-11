package com.business.report.expe.controller.sncr;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr1301Response;
import com.business.report.expe.service.sncr.Sncr1301Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/sncr1301")
public class Sncr1301Controller {

    private final Sncr1301Service sncr1301Service;

    public Sncr1301Controller(Sncr1301Service sncr1301Service) {
        this.sncr1301Service = sncr1301Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Sncr1301Response> consultarDeudas(@RequestBody RutRequest request)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Sncr1301Response> response = sncr1301Service.consultarDeudas(request);
        return ResponseEntity.ok(response.get());
    }
}
