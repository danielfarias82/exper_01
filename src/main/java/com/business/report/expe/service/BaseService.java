package com.business.report.expe.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public abstract class BaseService<T> {

    private final RestTemplate restTemplate;
    private final TokenServiceImpl tokenService;

    public BaseService(RestTemplate restTemplate, TokenServiceImpl tokenService) {
        this.restTemplate = restTemplate;
        this.tokenService = tokenService;
    }

    @CircuitBreaker(name = "defaultService", fallbackMethod = "fallbackResponse")
    @Retry(name = "defaultService")
    @TimeLimiter(name = "defaultService")
    public CompletableFuture<T> callApi(String endpoint, ParameterizedTypeReference<T> responseType,
            Map<String, String> requestBody) {
        return CompletableFuture.supplyAsync(() -> {
            String accessToken = tokenService.getAccessToken();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + accessToken);
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

            try {
                ResponseEntity<T> response = restTemplate.exchange(
                        endpoint, HttpMethod.POST, entity, responseType);
                return response.getBody();
            } catch (HttpClientErrorException.BadRequest e) {
                throw handleBadRequest(e);
            } catch (HttpStatusCodeException e) {
                throw new RuntimeException("Error en la API: " + e.getResponseBodyAsString(), e);
            } catch (Exception e) {
                throw new RuntimeException("Error inesperado: " + e.getMessage(), e);
            }
        });
    }

    private RuntimeException handleBadRequest(HttpClientErrorException.BadRequest e) {
        String responseBody = e.getResponseBodyAsString();
        if (responseBody.contains("\"errorCode\": \"10005\"")) {
            return new RuntimeException("Error: Rut inválido.");
        } else {
            return new RuntimeException("Error desconocido: " + responseBody);
        }
    }

    private CompletableFuture<T> fallbackResponse(String endpoint, ParameterizedTypeReference<T> responseType,
            Map<String, String> requestBody, Throwable t) {
        System.err.println("Fallback ejecutado para " + endpoint + ". Motivo: " + t.getMessage());
        return CompletableFuture.completedFuture(null);
    }
}
