package com.business.report.expe.service.sncr;

import com.business.report.expe.model.ApiWrapperResponse;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr3302Response;
import com.business.report.expe.service.BaseService;
import com.business.report.expe.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Sncr3302Service extends BaseService<ApiWrapperResponse<Sncr3302Response>> {

    @Value("${experian.services.url}")
    private String baseUrl;

    @Value("${experian.services.endpoints.sncr3302}")
    private String sncr3302Endpoint;

    public Sncr3302Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Sncr3302Response> consultarRut(RutRequest request) {
        return callApi(baseUrl + sncr3302Endpoint,
                new ParameterizedTypeReference<ApiWrapperResponse<Sncr3302Response>>() {
                },
                Map.of(
                        "rut", request.getRut(),
                        "temporalidad", request.getTemporalidad() // Enviando el campo temporalidad
                ))
                .thenApply(wrapper -> (wrapper != null) ? wrapper.getData() : null);
    }
}
