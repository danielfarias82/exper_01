package com.business.report.expe.controller;

import com.business.report.expe.model.Irut0202Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.Irut0202Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/irut0202")
public class Irut0202Controller {

    private final Irut0202Service irut0202Service;

    public Irut0202Controller(Irut0202Service irut0202Service) {
        this.irut0202Service = irut0202Service;
    }

    @PostMapping("/consultar")
    public ResponseEntity<Irut0202Response> consultarRut(@RequestBody RutRequest request) {
        Irut0202Response response = irut0202Service.consultarRut(request);
        return ResponseEntity.ok(response);
    }
}
