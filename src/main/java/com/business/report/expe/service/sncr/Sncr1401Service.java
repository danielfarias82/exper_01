package com.business.report.expe.service.sncr;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr1401Response;
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
public class Sncr1401Service extends BaseService<Sncr1401Response> {

    @Value("${experian.services.url}")
    private String baseUrl;

    @Value("${experian.services.endpoints.sncr1401}")
    private String endpoint;

    public Sncr1401Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Sncr1401Response> consultarPeriodosDeuda(RutRequest request) {
        String url = baseUrl + endpoint;
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("rut", request.getRut());

        return callApi(url, new ParameterizedTypeReference<Sncr1401Response>() {
        }, requestBody);
    }
}
