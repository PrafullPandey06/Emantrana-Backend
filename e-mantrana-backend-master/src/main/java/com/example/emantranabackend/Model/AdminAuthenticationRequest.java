package com.example.emantranabackend.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminAuthenticationRequest {
    private String userId;
    private String password;

    public AdminAuthenticationRequest() {
    }

    public AdminAuthenticationRequest(@JsonProperty("userId")String userId,
                                      @JsonProperty("password")String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
