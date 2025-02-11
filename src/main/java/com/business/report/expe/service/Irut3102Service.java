package com.business.report.expe.service;

import com.business.report.expe.model.Irut3102Response;
import com.business.report.expe.model.RutRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Irut3102Service extends BaseService<Irut3102Response> {

    @Value("${experian.services.url}")
    private String baseUrl;

    @Value("${experian.services.endpoints.irut3102}")
    private String endpoint;

    public Irut3102Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Irut3102Response> consultarRut(RutRequest request) {
        String url = baseUrl + endpoint;
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("rut", request.getRut());

        return callApi(url, new ParameterizedTypeReference<Irut3102Response>() {
        }, requestBody);
    }
}
