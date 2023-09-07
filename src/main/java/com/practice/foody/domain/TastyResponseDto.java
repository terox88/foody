package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TastyResponseDto {
    @JsonProperty("count")
    private int count;
    @JsonProperty("results")
    private List<RecipesDto> recipes;
}
