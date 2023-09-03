package com.practice.foody.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
@Entity(name ="RECIPES")
public class Recipes {
    @Id
    @NotNull
    @Column (name = "ID")
    private Long id;
   @Column(name = "NAME")
    private String name;
   @Column(name = "DESCRIPTION")
    private String description;
   @Column(name = "MEAL_TYPE")
    private MealType mealType;
   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
   @JoinTable(
           name = "JOIN_RECIPES_DAILY",
           joinColumns = {@JoinColumn(name = "RECIPES_ID", referencedColumnName = "ID")},
           inverseJoinColumns = {@JoinColumn(name = "DAILY_ID", referencedColumnName = "ID")}
   )
    private List<DailyRecipes> dailyRecipes;
    private List<Instruction> instructions;
    private List<Section> sections;

    private Nutrition nutrition;
}
