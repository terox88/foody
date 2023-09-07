package com.practice.foody.client;

import com.practice.foody.domain.MealType;
import com.practice.foody.domain.Preferences;
import com.practice.foody.domain.RecipesDto;
import com.practice.foody.domain.UserChose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TastyApiClientTest {
    @Autowired
    private TastyApiClient tastyApiClient;

    @Test
    void shouldGetRecipesTest () {
        //Given
        Preferences preferences = new Preferences();
        preferences.getPreferences().add(UserChose.GLUTEN_FREE);
        //When
        List<RecipesDto> response = tastyApiClient.getRecipes(preferences, MealType.BREAKFAST);
        //Then
        System.out.println("WYNIK!!!!!!");
        System.out.println(response.size());
    }
}
