package com.business.report.expe.service.sncr;

import com.business.report.expe.model.ApiWrapperResponse;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr1001Response;
import com.business.report.expe.service.BaseService;
import com.business.report.expe.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Sncr1001Service extends BaseService<ApiWrapperResponse<Sncr1001Response>> {

    @Value("${experian.api.base-url}")
    private String baseUrl;

    @Value("${experian.api.endpoints.sncr1001}")
    private String sncr1001Endpoint;

    public Sncr1001Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Sncr1001Response> consultarRut(RutRequest request) {
        return callApi(baseUrl + sncr1001Endpoint,
                new ParameterizedTypeReference<ApiWrapperResponse<Sncr1001Response>>() {
                },
                Map.of("rut", request.getRut()))
                .thenApply(wrapper -> (wrapper != null) ? wrapper.getData() : null);
    }
}
