package com.practice.foody.domain;

import lombok.Getter;

@Getter
public enum UserChose {
    DAIRY_FREE ("dairy_free"), GLUTEN_FREE ("gluten_free"), LOW_CALORIE ("low_calorie"), VEGETARIAN ("vegetarian");
    private String chose;

    private UserChose(String chose) {
        this.chose = chose;
    }
}
