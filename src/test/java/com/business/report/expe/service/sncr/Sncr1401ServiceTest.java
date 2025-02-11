package com.business.report.expe.service.sncr;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr1401Response;
import com.business.report.expe.service.TokenServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class Sncr1401ServiceTest {

    private static final String BASE_URL = "https://uat-api.experian.cl/";
    private static final String ENDPOINT = "cl/cr/sncr1401/v1/periodos-deudas/obtener";
    private static final String TEST_RUT = "10000304K";
    private static final String TEST_TOKEN = "DknTSdpwnmQlQlzuGa7MZJoPIqP8SGvA";

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TokenServiceImpl tokenService;

    private Sncr1401Service sncr1401Service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sncr1401Service = new Sncr1401Service(restTemplate, tokenService);
        ReflectionTestUtils.setField(sncr1401Service, "baseUrl", BASE_URL);
        ReflectionTestUtils.setField(sncr1401Service, "endpoint", ENDPOINT);
    }

    @Test
    void consultarPeriodosDeuda_Success() {
        // Given
        RutRequest request = new RutRequest();
        request.setRut(TEST_RUT);

        Sncr1401Response mockResponse = new Sncr1401Response();
        mockResponse.setSuccess(true);

        when(tokenService.getAccessToken()).thenReturn(TEST_TOKEN);
        when(restTemplate.exchange(
            eq(BASE_URL + ENDPOINT),
            any(),
            any(),
            eq(new ParameterizedTypeReference<Sncr1401Response>() {})
        )).thenReturn(org.springframework.http.ResponseEntity.ok(mockResponse));

        // When
        CompletableFuture<Sncr1401Response> result = sncr1401Service.consultarPeriodosDeuda(request);

        // Then
        assertNotNull(result);
        assertNotNull(result.join());
    }
}
