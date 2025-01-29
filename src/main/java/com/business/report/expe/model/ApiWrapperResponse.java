package com.business.report.expe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiWrapperResponse<T> {

    @JsonProperty("data")
    private T data;
}
