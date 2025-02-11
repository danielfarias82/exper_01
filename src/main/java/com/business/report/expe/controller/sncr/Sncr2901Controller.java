package com.business.report.expe.controller.sncr;

import com.business.report.expe.model.sncr.Sncr2901Request;
import com.business.report.expe.model.sncr.Sncr2901Response;
import com.business.report.expe.service.sncr.Sncr2901Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/sncr2901")
public class Sncr2901Controller {

    private final Sncr2901Service sncr2901Service;

    public Sncr2901Controller(Sncr2901Service sncr2901Service) {
        this.sncr2901Service = sncr2901Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Sncr2901Response> consultarDirectorioPersonas(@RequestBody Sncr2901Request request)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Sncr2901Response> response = sncr2901Service.consultarDirectorioPersonas(request);
        return ResponseEntity.ok(response.get());
    }
}
