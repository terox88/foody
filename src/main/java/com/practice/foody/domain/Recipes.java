package com.practice.foody.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity(name ="RECIPES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
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
    @OneToMany(
            targetEntity = Instruction.class,
            mappedBy = "recipes",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private List<Instruction> instructions;
    @OneToMany(
            targetEntity = Section.class,
            mappedBy = "recipes",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private List<Section> sections;
    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "NUTRITION_ID")
    private Nutrition nutrition;
}
