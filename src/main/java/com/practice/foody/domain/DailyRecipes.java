package com.practice.foody.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity (name = "daily_recipes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DailyRecipes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "DAY")
    private LocalDate day;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private List<Recipe> recipes = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "WEEKLY_RECIPES_ID")
    private WeeklyRecipes weeklyRecipes;
    @Setter
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASK_ID")
    private TodoistTask todoistTask;

    public DailyRecipes(LocalDate day, WeeklyRecipes weeklyRecipes) {
        this.day = day;
        this.weeklyRecipes = weeklyRecipes;
    }


    public String getShopList() {
        StringBuilder shopList = new StringBuilder("Shop list for " + day + "\n");
        Set<String> shopSet = recipes.stream()
                .flatMap(recipe -> recipe.getSections().stream()
                        .flatMap(section -> section.getComponents().stream()
                                .map(Component::getIngredient)))
                .collect(Collectors.toSet());
        for (String ingredient : shopSet) {
            shopList.append(ingredient).append("\n");
        }
        return shopList.toString();
    }
}
