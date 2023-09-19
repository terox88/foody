package com.practice.foody.service;

import com.practice.foody.domain.*;
import com.practice.foody.exception.NoDailyRecipeException;
import com.practice.foody.exception.NoWeeklyRecipesException;
import com.practice.foody.exception.RecipeNotFoundException;
import com.practice.foody.exception.UserNotFoundException;
import com.practice.foody.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final DailyRecipesRepository dailyRecipesRepository;
    private final WeeklyRecipesRepository weeklyRecipesRepository;
    private final TodoistProjectRepository todoistProjectRepository;
    private final  TodoistTaskRepository toDoistTaskRepository;

    public Recipe saveRecipe(Recipe recipe) {
        for(Instruction instruction : recipe.getInstructions()) {
            instruction.setRecipe(recipe);
        }
        for (Section section : recipe.getSections()) {
            section.setRecipe(recipe);
            for(Component component : section.getComponents()) {
                component.setSection(section);
                for(Measurements measurements : component.getMeasurements()) {
                    measurements.setComponent(component);
                }
            }
        }
        return recipeRepository.save(recipe);
    }
    public void deleteRecipe(long id) {
        recipeRepository.deleteById(id);
    }
    public Recipe getRecipe(long id) throws RecipeNotFoundException {
        return recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUser(long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public DailyRecipes saveDailyRecipes(DailyRecipes dailyRecipes){
        return dailyRecipesRepository.save(dailyRecipes);

    }
    public DailyRecipes getDailyRecipes(long id) throws NoDailyRecipeException {
        return dailyRecipesRepository.findById(id).orElseThrow(NoDailyRecipeException::new);
    }
    public WeeklyRecipes saveWeeklyRecipes(WeeklyRecipes weeklyRecipes){
        return weeklyRecipesRepository.save(weeklyRecipes);
    }
    public WeeklyRecipes getWeeklyRecipes(long id) throws  NoWeeklyRecipesException{
        return weeklyRecipesRepository.findById(id).orElseThrow(NoWeeklyRecipesException:: new);
    }

    public TodoistProject saveTodoistProject(TodoistProject project) {
        return todoistProjectRepository.save(project);
    }
    public TodoistTask saveTodoistTask(TodoistTask task) {
        return toDoistTaskRepository.save(task);
    }
}
