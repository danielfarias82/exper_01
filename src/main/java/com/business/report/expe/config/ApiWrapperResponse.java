package com.business.report.expe.config;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class ApiWrapperResponse<T> {

    @JsonAlias("data")
    private T data;
}
