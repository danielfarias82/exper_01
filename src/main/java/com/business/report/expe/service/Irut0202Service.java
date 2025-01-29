package com.business.report.expe.service;

import com.business.report.expe.config.RestTemplateConfig;
import com.business.report.expe.model.Irut0202Response;
import com.business.report.expe.model.RutRequest;
import com.business.report.expe.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class Irut0202Service {

    @Value("${experian.api.base-url}")
    private String baseUrl;

    @Value("${experian.api.endpoints.irut0202}")
    private String irut0202Endpoint;

    private final RestTemplate restTemplate;
    private final TokenServiceImpl tokenService;

    public Irut0202Service(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        this.restTemplate = restTemplate;
        this.tokenService = tokenService;
    }

    public Irut0202Response consultarRut(RutRequest request) {
        String accessToken = tokenService.getAccessToken();
        String fullUrl = baseUrl + irut0202Endpoint;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(Map.of("rut", request.getRut()), headers);

        try {
            ResponseEntity<Irut0202Response> response = restTemplate.exchange(
                    fullUrl, HttpMethod.POST, entity, Irut0202Response.class);

            return response.getBody();
        } catch (HttpClientErrorException.BadRequest e) {
            // Captura errores 400 (Bad Request)
            throw handleBadRequest(e);
        } catch (HttpStatusCodeException e) {
            // Captura cualquier otro error HTTP
            throw new RuntimeException("Error en la consulta a Experian: " + e.getResponseBodyAsString(), e);
        } catch (Exception e) {
            // Captura errores generales
            throw new RuntimeException("Error inesperado en la consulta a Experian: " + e.getMessage(), e);
        }
    }

    private RuntimeException handleBadRequest(HttpClientErrorException.BadRequest e) {
        String responseBody = e.getResponseBodyAsString();
        System.out.println("Error recibido: " + responseBody);

        if (responseBody.contains("\"errorCode\": \"10005\"")) {
            return new RuntimeException("Error en la consulta: Rut inválido.");
        } else {
            return new RuntimeException("Error desconocido en la consulta: " + responseBody);
        }
    }
}