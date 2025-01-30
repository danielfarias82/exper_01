package com.business.report.expe.service.sncr;

import com.business.report.expe.model.ApiWrapperResponse;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr0501Response;
import com.business.report.expe.service.BaseService;
import com.business.report.expe.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Sncr0501Service extends BaseService<ApiWrapperResponse<Sncr0501Response>> {

    @Value("${experian.api.base-url}")
    private String baseUrl;

    @Value("${experian.api.endpoints.sncr0501}")
    private String sncr0501Endpoint;

    public Sncr0501Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Sncr0501Response> consultarRut(RutRequest request) {
        return callApi(baseUrl + sncr0501Endpoint,
                new ParameterizedTypeReference<ApiWrapperResponse<Sncr0501Response>>() {
                },
                Map.of("rut", request.getRut()))
                .thenApply(wrapper -> (wrapper != null) ? wrapper.getData() : null);
    }
}
