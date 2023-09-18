package com.practice.foody.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity(name ="RECIPES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Recipe {
    @Id
    @NotNull
    @Column (name = "ID")
    private Long id;
   @Column(name = "NAME")
    private String name;
   @Column(name = "DESCRIPTION", length = 1000)
    private String description;
   @Column(name = "MEAL_TYPE")
   @Setter
    private MealType mealType;
   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
   @JoinTable(
           name = "JOIN_RECIPES_DAILY",
           joinColumns = {@JoinColumn(name = "RECIPES_ID", referencedColumnName = "ID")},
           inverseJoinColumns = {@JoinColumn(name = "DAILY_ID", referencedColumnName = "ID")}
   )
    private List<DailyRecipes> dailyRecipes =new ArrayList<>();
    @OneToMany(
            targetEntity = Instruction.class,
            mappedBy = "recipe",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Instruction> instructions;
    @OneToMany(
            targetEntity = Section.class,
            mappedBy = "recipe",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Section> sections;
    @OneToOne (cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "NUTRITION_ID")
    private Nutrition nutrition;

    public Recipe(Long id, String name, String description, MealType mealType, List<Instruction> instructions, List<Section> sections, Nutrition nutrition) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mealType = mealType;
        this.instructions = instructions;
        this.sections = sections;
        this.nutrition = nutrition;
    }
}
