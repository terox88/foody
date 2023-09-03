package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NutritionDto {
    @JsonProperty("protein")
    private int	protein;
    @JsonProperty("fat")
    private int	fat;
    @JsonProperty("calories")
    private int	calories;
    @JsonProperty("sugar")
    private int	sugar;
    @JsonProperty("carbohydrates")
    private int	carbohydrates;
    @JsonProperty("fiber")
    private int	fiber;
}
