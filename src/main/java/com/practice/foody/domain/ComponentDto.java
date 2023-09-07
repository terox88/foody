package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComponentDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("position")
    private int position;
    @JsonProperty("raw_text")
    private String text;
    @JsonProperty("measurements")
    private List<MeasurementsDto> measurements;
    @JsonProperty("ingredient")
    private  IngredientDto ingredient;

}
