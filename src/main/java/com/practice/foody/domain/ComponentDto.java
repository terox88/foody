package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ComponentDto {
    private long id;
    private int position;
    private String text;
    private List<MeasurementsDto> measurements;
    private  IngredientDto ingredient;

}
