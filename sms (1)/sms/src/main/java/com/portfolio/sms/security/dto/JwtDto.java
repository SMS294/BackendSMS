package com.portfolio.sms.security.dto;

public class JwtDto {
    private String token;


    //constructor

    public JwtDto(String token) {
        this.token = token;
    }
    //Getter and Setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}







