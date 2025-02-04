package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiWrapperResponse<T> {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("errors")
    private Object errors;

    @JsonProperty("data")
    private T data;
}
