package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class DailyRecipesDto {
    private long id;
    private LocalDate day;
    private RecipesDto breakfast;
    private RecipesDto brunch;
    private RecipesDto lunch;
    private RecipesDto diner;
    private ShopList shopList;

}
