package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "nutrition")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Nutrition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "PROTEIN")
    private int	protein;
    @Column(name = "FAT")
    private int	fat;
    @Column(name = "CALORIES")
    private int	calories;
    @Column(name = "SUGAR")
    private int	sugar;
    @Column(name = "CARBOHYDRATES")
    private int	carbohydrates;
    @Column(name = "FIBER")
    private int	fiber;

    public Nutrition(int protein, int fat, int calories, int sugar, int carbohydrates, int fiber) {
        this.protein = protein;
        this.fat = fat;
        this.calories = calories;
        this.sugar = sugar;
        this.carbohydrates = carbohydrates;
        this.fiber = fiber;
    }
}
