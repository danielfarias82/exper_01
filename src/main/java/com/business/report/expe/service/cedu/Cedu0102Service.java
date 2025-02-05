package com.business.report.expe.service.cedu;

import com.business.report.expe.model.ApiWrapperResponse;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.cedu.Cedu0102Response;
import com.business.report.expe.service.BaseService;
import com.business.report.expe.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Cedu0102Service extends BaseService<ApiWrapperResponse<Cedu0102Response>> {

    @Value("${experian.services.url}")
    private String baseUrl;

    @Value("${experian.services.endpoints.cedu0102}")
    private String cedu0102Endpoint;

    public Cedu0102Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        super(restTemplate, tokenService);
    }

    public CompletableFuture<Cedu0102Response> consultarCedula(RutRequest request) {
        return callApi(baseUrl + cedu0102Endpoint,
                new ParameterizedTypeReference<ApiWrapperResponse<Cedu0102Response>>() {
                },
                Map.of(
                        "rut", request.getRut(),
                        "serie", request.getSerie()))
                .thenApply(wrapper -> (wrapper != null) ? wrapper.getData() : null);
    }
}
