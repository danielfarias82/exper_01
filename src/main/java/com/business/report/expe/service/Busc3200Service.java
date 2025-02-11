package com.business.report.expe.service;

import com.business.report.expe.model.Busc3200Response;
import com.business.report.expe.model.DescripcionRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Busc3200Service extends BaseService<Busc3200Response> {

    @Value("${experian.services.url}")
    private String baseUrl;

    @Value("${experian.services.endpoints.busc3200}")
    private String endpoint;

    public Busc3200Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Busc3200Response> consultarPersona(DescripcionRequest request) {
        String url = baseUrl + endpoint;
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("descripcion", request.getDescripcion());

        return callApi(url, new ParameterizedTypeReference<Busc3200Response>() {
        }, requestBody);
    }
}
