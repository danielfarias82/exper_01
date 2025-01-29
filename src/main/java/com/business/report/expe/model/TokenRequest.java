package com.business.report.expe.model;

import lombok.Data;

@Data
public class TokenRequest {
    private String client_id;
    private String client_secret;
    private String username;
    private String password;
    private String grant_type;
}