package com.practice.foody.controller;

import com.practice.foody.domain.DailyRecipes;
import com.practice.foody.domain.DailyRecipesDto;
import com.practice.foody.domain.RecipeDto;
import com.practice.foody.domain.TodoistTaskDto;
import com.practice.foody.exception.*;
import com.practice.foody.mapper.DomainMapper;
import com.practice.foody.mapper.TastyApiMapper;
import com.practice.foody.service.DbService;
import com.practice.foody.service.TodoistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/recipe")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RecipeController {
    private final DbService dbService;
    private final DomainMapper domainMapper;
    private final TodoistService todoistService;
    private final TastyApiMapper tastyApiMapper;

    @GetMapping(value = "/daily")
    public ResponseEntity<DailyRecipesDto> getDailyRecipes(@RequestParam long dailyId) throws NoDailyRecipeException {
        return ResponseEntity.ok(domainMapper.mapToDailyRecipesDto(dbService.getDailyRecipes(dailyId)));
    }
    @PostMapping(value = "/daily")
    public ResponseEntity<TodoistTaskDto> createShoppingList(@RequestParam long dailyId) throws NoDailyRecipeException, UserNotFoundException, AlreadyCreatedTaskExcepton, CannotCreateTaskException {
        DailyRecipes dailyRecipes = dbService.getDailyRecipes(dailyId);
        long userId = dailyRecipes.getWeeklyRecipes().getUser().getId();
        return ResponseEntity.ok(todoistService.createTask(userId,dailyId));
    }
    @GetMapping
    public ResponseEntity<RecipeDto> getRecipe(@RequestParam long recipeId) throws RecipeNotFoundException {
        return ResponseEntity.ok(tastyApiMapper.mapToRecipeDto(dbService.getRecipe(recipeId)));
    }
    @GetMapping(value = "{dailyId}")
    public ResponseEntity<List<RecipeDto>> getRecipesForDay(@PathVariable long dailyId) throws NoDailyRecipeException{
        DailyRecipes dailyRecipes = dbService.getDailyRecipes(dailyId);
        return ResponseEntity.ok(tastyApiMapper.mapToRecipeDtoList(dailyRecipes.getRecipes()));
    }

}
