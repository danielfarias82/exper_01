package com.business.report.expe.service.sncr;

import com.business.report.expe.model.sncr.Sncr2901Request;
import com.business.report.expe.model.sncr.Sncr2901Response;
import com.business.report.expe.service.BaseService;
import com.business.report.expe.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Sncr2901Service extends BaseService<Sncr2901Response> {

    @Value("${experian.services.url}")
    private String baseUrl;

    @Value("${experian.services.endpoints.sncr2901}")
    private String endpoint;

    public Sncr2901Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Sncr2901Response> consultarDirectorioPersonas(Sncr2901Request request) {
        String url = baseUrl + endpoint;
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("rut", request.getRut());
        requestBody.put("validaNuevos", request.getValidaNuevos());

        return callApi(url, new ParameterizedTypeReference<Sncr2901Response>() {
        }, requestBody);
    }
}
