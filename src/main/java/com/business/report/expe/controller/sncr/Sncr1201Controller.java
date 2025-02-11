package com.business.report.expe.controller.sncr;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr1201Response;
import com.business.report.expe.service.sncr.Sncr1201Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/sncr1201")
public class Sncr1201Controller {

    private final Sncr1201Service sncr1201Service;

    public Sncr1201Controller(Sncr1201Service sncr1201Service) {
        this.sncr1201Service = sncr1201Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Sncr1201Response> consultarProtestos(@RequestBody RutRequest request)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Sncr1201Response> response = sncr1201Service.consultarProtestos(request);
        return ResponseEntity.ok(response.get());
    }
}
