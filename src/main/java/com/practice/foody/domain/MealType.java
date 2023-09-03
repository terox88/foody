package com.practice.foody.domain;

import lombok.Getter;

@Getter
public enum MealType {
    BREAKFAST("breakfast"),
    BRUNCH ("brunch"),
    LUNCH("lunch"),
    DINNER("dinner");
    private final String tag;

    private MealType (String tag) {
        this.tag = tag;
    }
}
