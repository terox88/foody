package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class WeeklyRecipesDto {
    private long id;
    private long week;
    private List<DailyRecipesDto> dailyRecipesDtos;
}
