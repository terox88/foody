package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoisTokenDto {
    @JsonProperty("access_token")
    private String token;
    @JsonProperty("token_type")
    private String type;

    public TodoisTokenDto() {
    }
}
