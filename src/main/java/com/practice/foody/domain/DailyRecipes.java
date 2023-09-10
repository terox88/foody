package com.practice.foody.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "SHOPLIST_ID")
    private ShopList shopList;
    @Setter
    @ManyToOne
    @JoinColumn(name = "WEEKLY_RECIPES_ID")
    private WeeklyRecipes weeklyRecipes;
}
