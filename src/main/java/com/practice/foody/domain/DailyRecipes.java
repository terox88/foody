package com.practice.foody.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity (name = "daily_recipes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class DailyRecipes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "DAY")
    private LocalDate day;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Set<Recipe> recipes = new HashSet<>();
   @Column(name = "SHOP_LIST", length = 5000)
    private String shopList;
    @Setter
    @ManyToOne
    @JoinColumn(name = "WEEKLY_RECIPES_ID")
    private WeeklyRecipes weeklyRecipes;

    public DailyRecipes(LocalDate day, WeeklyRecipes weeklyRecipes) {
        this.day = day;
        this.weeklyRecipes = weeklyRecipes;
        this.shopList = toString();
    }
}
