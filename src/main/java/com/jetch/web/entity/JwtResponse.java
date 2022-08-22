package com.jetch.web.entity;

public class JwtResponse {
    private String jwtToken;

    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

    private Long statusCode;

    public JwtResponse() {
    }

    public JwtResponse(String jwtToken, Long statusCode) {
        this.jwtToken = jwtToken;
        this.statusCode = statusCode;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
