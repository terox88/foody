package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnitDto {
    @JsonProperty("system")
    private String system;
    @JsonProperty("name")
    private String name;

    public UnitDto() {
    }
}

