package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("instructions")
    private List<InstructionDto> instructions;
    @JsonProperty("sections")
    private List<SectionDto> sections;
    @JsonProperty("nutrition")
    private NutritionDto nutrition;
    private MealType mealType;

    public RecipeDto() {
    }
}
