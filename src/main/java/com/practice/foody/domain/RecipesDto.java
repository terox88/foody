package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class RecipesDto {
    private long id;
    private String name;
    private String description;
    private List<InstructionDto> instructions;
    private List<SectionDto> sections;
    private NutritionDto nutrition;



}
