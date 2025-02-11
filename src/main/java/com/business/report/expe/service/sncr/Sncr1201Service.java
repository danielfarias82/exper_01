package com.business.report.expe.service.sncr;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr1201Response;
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
public class Sncr1201Service extends BaseService<Sncr1201Response> {

    @Value("${experian.services.url}")
    private String baseUrl;

    @Value("${experian.services.endpoints.sncr1201}")
    private String endpoint;

    public Sncr1201Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Sncr1201Response> consultarProtestos(RutRequest request) {
        String url = baseUrl + endpoint;
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("rut", request.getRut());

        return callApi(url, new ParameterizedTypeReference<Sncr1201Response>() {
        }, requestBody);
    }
}
