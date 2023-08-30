package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnitDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("system")
    private String system;
    @JsonProperty("name")
    private String name;
    @JsonProperty("quantity")
    private String quantity;
}
