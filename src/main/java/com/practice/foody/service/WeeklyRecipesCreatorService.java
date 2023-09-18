package com.practice.foody.service;

import com.practice.foody.client.TastyApiClient;
import com.practice.foody.domain.*;
import com.practice.foody.exception.BadQueryException;
import com.practice.foody.mapper.TastyApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class WeeklyRecipesCreatorService {
    private final TastyApiMapper tastyApiMapper;
    private final DbService dbService;
    private final TastyApiClient tastyApiClient;
    private final Random generator = new Random();

    @Transactional
    public WeeklyRecipes createWeeklyRecipes (User user, LocalDate beginDay) throws BadQueryException {
        WeeklyRecipes weeklyRecipes = new WeeklyRecipes(beginDay,beginDay.plusDays(7), user);
        LocalDate day = beginDay;
        int count;
        int offset;
        int bound;
        count = tastyApiClient.getRecipesCount(tastyApiClient.createQuery(user.getPreferences(), MealType.BREAKFAST));
        bound = count/40;
        offset = count > 80 ?  generator.nextInt(bound)*40 : 0;
        List<Recipe> breakfasts = new ArrayList<>(tastyApiMapper.mapToRecipeList(tastyApiClient.getRecipes(tastyApiClient.createQuery(user.getPreferences(),MealType.BREAKFAST, offset))));

        count = tastyApiClient.getRecipesCount(tastyApiClient.createQuery(user.getPreferences(), MealType.BRUNCH))/40;
        bound = count/40;
        offset = count > 80 ?  generator.nextInt(bound)*40 : 0;
        List<Recipe> brunches = new ArrayList<>(tastyApiMapper.mapToRecipeList(tastyApiClient.getRecipes(tastyApiClient.createQuery(user.getPreferences(),MealType.BRUNCH, offset))));

        count = tastyApiClient.getRecipesCount(tastyApiClient.createQuery(user.getPreferences(), MealType.LUNCH))/40;
        bound = count/40;
        offset = count > 80 ?  generator.nextInt(bound)*40 : 0;
        List<Recipe> lunches = new ArrayList<>(tastyApiMapper.mapToRecipeList(tastyApiClient.getRecipes(tastyApiClient.createQuery(user.getPreferences(),MealType.LUNCH, offset))));

        count = tastyApiClient.getRecipesCount(tastyApiClient.createQuery(user.getPreferences(), MealType.DINNER))/40;
        bound = count/40;
        offset = count > 80 ?  generator.nextInt(bound)*40 : 0;
        List<Recipe> dinners = new ArrayList<>(tastyApiMapper.mapToRecipeList(tastyApiClient.getRecipes(tastyApiClient.createQuery(user.getPreferences(),MealType.DINNER, offset))));
        int daysLeft = 7;
        while (day.isBefore(beginDay.plusDays(7))) {
           DailyRecipes dailyRecipes = new DailyRecipes(day,weeklyRecipes);
           int index;
           Recipe recipe;
           boolean wasAdded = false;
           while (!wasAdded) {
               index = generator.nextInt(breakfasts.size());
               recipe = breakfasts.get(index);
               if(isNoDuplicates(weeklyRecipes, recipe)) {
                   recipe.setMealType(MealType.BREAKFAST);
                   dailyRecipes.getRecipes().add(dbService.saveRecipe(recipe));
                   wasAdded = true;
                   if(breakfasts.size() > daysLeft) {
                       breakfasts.remove(index);
                   }
               }
           }
           wasAdded = false;
            while (!wasAdded) {
                index = generator.nextInt(brunches.size());
                recipe = brunches.get(index);
                if(isNoDuplicates(weeklyRecipes, recipe)) {
                    recipe.setMealType(MealType.BRUNCH);
                    dailyRecipes.getRecipes().add(dbService.saveRecipe(recipe));
                    wasAdded = true;
                    if(brunches.size() > daysLeft) {
                        brunches.remove(index);
                    }
                }
            }
            wasAdded = false;
            while (!wasAdded) {
                index = generator.nextInt(lunches.size());
                recipe = lunches.get(index);
                if(isNoDuplicates(weeklyRecipes, recipe)) {
                    recipe.setMealType(MealType.LUNCH);
                    dailyRecipes.getRecipes().add(dbService.saveRecipe(recipe));
                    wasAdded = true;
                    if(lunches.size() > daysLeft) {
                        lunches.remove(index);
                    }
                }
            }
            wasAdded = false;
            while (!wasAdded) {
                index = generator.nextInt(dinners.size());
                recipe = dinners.get(index);
                if(isNoDuplicates(weeklyRecipes, recipe)) {
                    recipe.setMealType(MealType.DINNER);
                    dailyRecipes.getRecipes().add(dbService.saveRecipe(recipe));
                    wasAdded = true;
                    if(dinners.size() > daysLeft) {
                        dinners.remove(index);
                    }
                }
            }
            weeklyRecipes.getDailyRecipes().add(dbService.saveDailyRecipes(dailyRecipes));
            daysLeft--;
            day = day.plusDays(1);


        }
        user.getWeeklyRecipes().add(dbService.saveWeeklyRecipes(weeklyRecipes));
        dbService.saveUser(user);
        return weeklyRecipes;
    }

    public boolean isNoDuplicates(final WeeklyRecipes weeklyRecipes, final Recipe recipe) {
        for(int i = 0; i < weeklyRecipes.getDailyRecipes().size(); i++) {
            for(Recipe oldRecipe : weeklyRecipes.getDailyRecipes().get(i).getRecipes()) {
                if(oldRecipe.getId().equals(recipe.getId())) {
                    return false;
                }
            }
        }
        return true;
    }
}
