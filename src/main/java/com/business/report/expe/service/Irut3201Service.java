package com.business.report.expe.service;

import com.business.report.expe.model.ApiWrapperResponse;
import com.business.report.expe.model.Irut3201Response;
import com.business.report.expe.model.RutRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Irut3201Service extends BaseService<ApiWrapperResponse<Irut3201Response>> {

    @Value("${experian.api.base-url}")
    private String baseUrl;

    @Value("${experian.api.endpoints.irut3201}")
    private String irut3201Endpoint;

    public Irut3201Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Irut3201Response> consultarRut(RutRequest request) {
        return callApi(baseUrl + irut3201Endpoint,
                new ParameterizedTypeReference<ApiWrapperResponse<Irut3201Response>>() {
                },
                Map.of("rut", request.getRut()))
                .thenApply(wrapper -> (wrapper != null) ? wrapper.getData() : null);
    }
}
