package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeudaWrapperResponse {

    @JsonProperty("data")
    private Irut1603Response data;
}
