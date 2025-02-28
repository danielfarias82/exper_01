package com.business.report.expe.service;

import com.business.report.expe.model.ApiWrapperResponse;
import com.business.report.expe.model.Irut0502Response;
import com.business.report.expe.model.RutRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Irut0502Service extends BaseService<ApiWrapperResponse<Irut0502Response>> {

    @Value("${experian.services.url}")
    private String baseUrl;

    @Value("${experian.services.endpoints.irut0502}")
    private String irut0502Endpoint;

    public Irut0502Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Irut0502Response> consultarRut(RutRequest request) {
        return callApi(baseUrl + irut0502Endpoint,
                new ParameterizedTypeReference<ApiWrapperResponse<Irut0502Response>>() {
                },
                Map.of("rut", request.getRut()))
                .thenApply(wrapper -> (wrapper != null) ? wrapper.getData() : null);
    }
}
