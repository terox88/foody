package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NutritionDto {
    private long id;
    private int	protein;
    private int	fat;
    private int	calories;
    private int	sugar;
    private int	carbohydrates;
    private int	fiber;
}
