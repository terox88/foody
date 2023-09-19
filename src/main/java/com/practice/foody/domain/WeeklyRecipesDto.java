package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class WeeklyRecipesDto {
    private long id;
    private LocalDate weekBegin;
    private LocalDate weekEnd;
    private List<Long> dailyRecipesId;
}
