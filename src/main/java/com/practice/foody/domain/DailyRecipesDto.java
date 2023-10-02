package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class DailyRecipesDto {
    private long id;
    private LocalDate day;
    private List<Long> recipesId;
    private TodoistTaskDto todoistTaskDto;
    private String shoppingList;

}
