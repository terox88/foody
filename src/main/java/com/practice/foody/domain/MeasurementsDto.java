package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeasurementsDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("quantity")
    private String quantity;
    @JsonProperty("unit")
    private UnitDto unit;

    public MeasurementsDto() {
    }
}
