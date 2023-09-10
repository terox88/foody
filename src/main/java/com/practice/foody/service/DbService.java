package com.practice.foody.service;

import com.practice.foody.domain.*;
import com.practice.foody.exception.RecipeNotFoundException;
import com.practice.foody.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DbService {
    private final RecipeRepository recipeRepository;

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
    public Recipe findRecipe(long id) throws RecipeNotFoundException {
        return recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
    }
}
