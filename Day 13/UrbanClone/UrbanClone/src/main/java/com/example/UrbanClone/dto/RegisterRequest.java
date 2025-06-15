package com.example.UrbanClone.dto;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String location;

    @JsonProperty("isProvider")
    private boolean provider;

    public boolean isProvider() {
        return provider;
    }

}
