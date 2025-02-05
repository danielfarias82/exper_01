package com.business.report.expe.service;

import com.business.report.expe.model.ApiWrapperResponse;
import com.business.report.expe.model.Irut1603Response;
import com.business.report.expe.model.RutRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Irut1603Service extends BaseService<ApiWrapperResponse<Irut1603Response>> {

    @Value("${experian.services.url}")
    private String baseUrl;

    @Value("${experian.services.endpoints.irut1603}")
    private String irut1603Endpoint;

    public Irut1603Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Irut1603Response> consultarRut(RutRequest request) {
        return callApi(baseUrl + irut1603Endpoint,
                new ParameterizedTypeReference<ApiWrapperResponse<Irut1603Response>>() {
                },
                Map.of("rut", request.getRut()))
                .thenApply(wrapper -> (wrapper != null) ? wrapper.getData() : null);
    }
}
