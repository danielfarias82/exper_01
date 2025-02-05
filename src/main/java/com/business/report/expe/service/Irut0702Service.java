package com.business.report.expe.service;

import com.business.report.expe.model.ApiWrapperResponse;
import com.business.report.expe.model.Irut0702Response;
import com.business.report.expe.model.RutRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Irut0702Service extends BaseService<ApiWrapperResponse<Irut0702Response>> {

    @Value("${experian.services.url}")
    private String baseUrl;

    @Value("${experian.services.endpoints.irut0702}")
    private String irut0702Endpoint;

    public Irut0702Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Irut0702Response> consultarRut(RutRequest request) {
        return callApi(baseUrl + irut0702Endpoint,
                new ParameterizedTypeReference<ApiWrapperResponse<Irut0702Response>>() {
                },
                Map.of("rut", request.getRut()))
                .thenApply(wrapper -> (wrapper != null) ? wrapper.getData() : null);
    }
}
