package com.business.report.expe.service.sncr;

import com.business.report.expe.model.RutRequest;
import com.business.report.expe.model.sncr.Sncr1201Response;
import com.business.report.expe.service.TokenServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class Sncr1201ServiceTest {

    private static final String BASE_URL = "https://uat-api.experian.cl/";
    private static final String ENDPOINT = "cl/cr/sncr1201/v1/protestos/obtener";
    private static final String TEST_RUT = "24647804K";
    private static final String TEST_TOKEN = "DknTSdpwnmQlQlzuGa7MZJoPIqP8SGvA";

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TokenServiceImpl tokenService;

    private Sncr1201Service sncr1201Service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sncr1201Service = new Sncr1201Service(restTemplate, tokenService);
        ReflectionTestUtils.setField(sncr1201Service, "baseUrl", BASE_URL);
        ReflectionTestUtils.setField(sncr1201Service, "endpoint", ENDPOINT);
    }

    @Test
    void consultarProtestos_Success() {
        // Given
        RutRequest request = new RutRequest();
        request.setRut(TEST_RUT);

        Sncr1201Response mockResponse = new Sncr1201Response();
        mockResponse.setSuccess(true);

        when(tokenService.getAccessToken()).thenReturn(TEST_TOKEN);
        when(restTemplate.exchange(
            eq(BASE_URL + ENDPOINT),
            any(),
            any(),
            eq(new ParameterizedTypeReference<Sncr1201Response>() {})
        )).thenReturn(org.springframework.http.ResponseEntity.ok(mockResponse));

        // When
        CompletableFuture<Sncr1201Response> result = sncr1201Service.consultarProtestos(request);

        // Then
        assertNotNull(result);
        assertNotNull(result.join());
    }
}
