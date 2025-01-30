package com.business.report.expe.service.sncr;

import com.business.report.expe.model.ApiWrapperResponse;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr3501Response;
import com.business.report.expe.service.BaseService;
import com.business.report.expe.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Sncr3501Service extends BaseService<ApiWrapperResponse<Sncr3501Response>> {

    @Value("${experian.api.base-url}")
    private String baseUrl;

    @Value("${experian.api.endpoints.sncr3501}")
    private String sncr3501Endpoint;

    public Sncr3501Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Sncr3501Response> consultarRut(RutRequest request) {
        return callApi(baseUrl + sncr3501Endpoint,
                new ParameterizedTypeReference<ApiWrapperResponse<Sncr3501Response>>() {
                },
                Map.of(
                    "rut", request.getRut() // Solo enviando el campo rut
                ))
                .thenApply(wrapper -> (wrapper != null) ? wrapper.getData() : null);
    }
}
