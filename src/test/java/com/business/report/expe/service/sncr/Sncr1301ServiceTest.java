package com.business.report.expe.service.sncr;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr1301Response;
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

class Sncr1301ServiceTest {

    private static final String BASE_URL = "https://uat-api.experian.cl/";
    private static final String ENDPOINT = "cl/cr/sncr1301/v1/deudas/obtener";
    private static final String TEST_RUT = "151786944";
    private static final String TEST_TOKEN = "DknTSdpwnmQlQlzuGa7MZJoPIqP8SGvA";

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TokenServiceImpl tokenService;

    private Sncr1301Service sncr1301Service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sncr1301Service = new Sncr1301Service(restTemplate, tokenService);
        ReflectionTestUtils.setField(sncr1301Service, "baseUrl", BASE_URL);
        ReflectionTestUtils.setField(sncr1301Service, "endpoint", ENDPOINT);
    }

    @Test
    void consultarDeudas_Success() {
        // Given
        RutRequest request = new RutRequest();
        request.setRut(TEST_RUT);

        Sncr1301Response mockResponse = new Sncr1301Response();
        mockResponse.setSuccess(true);

        when(tokenService.getAccessToken()).thenReturn(TEST_TOKEN);
        when(restTemplate.exchange(
            eq(BASE_URL + ENDPOINT),
            any(),
            any(),
            eq(new ParameterizedTypeReference<Sncr1301Response>() {})
        )).thenReturn(org.springframework.http.ResponseEntity.ok(mockResponse));

        // When
        CompletableFuture<Sncr1301Response> result = sncr1301Service.consultarDeudas(request);

        // Then
        assertNotNull(result);
        assertNotNull(result.join());
    }
}
