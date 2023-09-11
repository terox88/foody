package com.practice.foody.service;

import com.practice.foody.domain.*;
import com.practice.foody.exception.RecipeNotFoundException;
import com.practice.foody.exception.UserNotFoundException;
import com.practice.foody.repository.RecipeRepository;
import com.practice.foody.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

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
    public Recipe findRecipe(long id) throws RecipeNotFoundException {
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
}
