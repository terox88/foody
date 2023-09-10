package com.practice.foody.service;

import com.practice.foody.client.TastyApiClient;
import com.practice.foody.domain.*;
import com.practice.foody.exception.RecipeNotFoundException;
import com.practice.foody.mapper.TastyApiMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DbServiceTest {
    @Autowired
    private DbService dbService;
    @Autowired
    private TastyApiClient tastyApiClient;
    @Autowired
    private TastyApiMapper tastyApiMapper;

    @Test
    void shouldSaveRecipe() throws RecipeNotFoundException {
        //Given
        Preferences preferences = new Preferences();
        preferences.getPreferences().add(UserChose.GLUTEN_FREE);
        List<RecipeDto> response = tastyApiClient.getRecipes(tastyApiClient.createQuery(preferences, MealType.BREAKFAST,0));
        //When
        Recipe recipe = tastyApiMapper.mapToRecipe(response.get(4));
        dbService.saveRecipe(recipe);
        long recipeId = recipe.getId();
       Recipe receiveRecipe = dbService.findRecipe(recipeId);

        //Then
        Assertions.assertFalse(receiveRecipe.getSections().isEmpty());
        Assertions.assertFalse(receiveRecipe.getSections().get(0).getComponents().isEmpty());

    }
}
