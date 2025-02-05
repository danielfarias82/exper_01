package com.business.report.expe.service;

import com.business.report.expe.model.ApiWrapperResponse;
import com.business.report.expe.model.Irut8202Response;
import com.business.report.expe.model.RutRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Irut8202Service extends BaseService<ApiWrapperResponse<Irut8202Response>> {

    @Value("${experian.services.url}")
    private String baseUrl;

    @Value("${experian.services.endpoints.irut8202}")
    private String irut8202Endpoint;

    public Irut8202Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Irut8202Response> consultarRut(RutRequest request) {
        return callApi(baseUrl + irut8202Endpoint,
                new ParameterizedTypeReference<ApiWrapperResponse<Irut8202Response>>() {
                },
                Map.of("rut", request.getRut()))
                .thenApply(wrapper -> (wrapper != null) ? wrapper.getData() : null);
    }
}
