package com.business.report.expe.service;

import com.business.report.expe.model.ApiWrapperResponse;
import com.business.report.expe.model.Irut0802Response;
import com.business.report.expe.model.RutRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Irut0802Service extends BaseService<ApiWrapperResponse<Irut0802Response>> {

    @Value("${experian.api.base-url}")
    private String baseUrl;

    @Value("${experian.api.endpoints.irut0802}")
    private String irut0802Endpoint;

    public Irut0802Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Irut0802Response> consultarRut(RutRequest request) {
        return callApi(baseUrl + irut0802Endpoint,
                new ParameterizedTypeReference<ApiWrapperResponse<Irut0802Response>>() {
                },
                Map.of("rut", request.getRut()))
                .thenApply(wrapper -> (wrapper != null) ? wrapper.getData() : null);
    }
}
