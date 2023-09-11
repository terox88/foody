package com.practice.foody.service;

import com.practice.foody.client.TastyApiClient;
import com.practice.foody.domain.*;
import com.practice.foody.exception.RecipeNotFoundException;
import com.practice.foody.exception.UserNotFoundException;
import com.practice.foody.mapper.TastyApiMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DbServiceTest {
    @Autowired
    private DbService dbService;

    private Recipe recipe;
    @BeforeEach
    void preparingData() {
        Instruction instruction = new Instruction(1L,1,"Test");
        List<Instruction> instructions = Arrays.asList(instruction);
        Unit unit = new Unit("Testing system", "gram");
        Ingredient ingredient = new Ingredient(1L, "testing ingredient");
        Measurements measurements = new Measurements(1L,"12", unit);
        List<Measurements> measurementsList = Arrays.asList(measurements);
        Component component = new Component(1L,1, "test component", measurementsList, ingredient);
        List<Component> components = Arrays.asList(component);
        Section section = new Section("",1, components);
        List<Section> sections = Arrays.asList(section);
        Nutrition nutrition = new Nutrition(1,2,3,4,5,6);
        recipe = new Recipe(1L,"test recipe", "test", MealType.BREAKFAST, instructions, sections, nutrition);
    }



    @Test
    void shouldSaveRecipe() throws RecipeNotFoundException {
        //When
        dbService.saveRecipe(recipe);
        long id = recipe.getId();
        Recipe receivedRecipe = dbService.findRecipe(id);

        //Then
        Assertions.assertFalse(receivedRecipe.getSections().isEmpty());
        Assertions.assertFalse(receivedRecipe.getSections().get(0).getComponents().isEmpty());
        //CleanUp
        dbService.deleteRecipe(id);

    }
    @Test
    void shouldSaveUser () throws UserNotFoundException {
        //Given
        Preferences preferences = new Preferences();
        preferences.getPreferences().add(UserChose.LOW_CALORIE);
        User user = new User("test email", "password", preferences,Role.USER, LocalDate.now(),null);
        WeeklyRecipes weeklyRecipes = new WeeklyRecipes(LocalDate.now(), LocalDate.now().plusDays(7), user);
        DailyRecipes dailyRecipes = new DailyRecipes(LocalDate.now(), weeklyRecipes);
        dailyRecipes.getRecipes().add(recipe);
        weeklyRecipes.getDailyRecipes().add(dailyRecipes);
        user.getWeeklyRecipes().add(weeklyRecipes);
        //When
        dbService.saveUser(user);
        long id = user.getId();
        User savedUser = dbService.getUser(id);
        //Then
        Assertions.assertEquals("test recipe", savedUser.getWeeklyRecipes().get(0).getDailyRecipes().get(0).getRecipes().stream().toList().get(0).getName());
    }
}
