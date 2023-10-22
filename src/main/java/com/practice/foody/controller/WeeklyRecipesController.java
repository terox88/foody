package com.practice.foody.controller;

import com.practice.foody.domain.User;
import com.practice.foody.domain.WeeklyRecipes;
import com.practice.foody.domain.WeeklyRecipesDto;
import com.practice.foody.exception.BadQueryException;
import com.practice.foody.exception.NoWeeklyRecipesException;
import com.practice.foody.exception.UserNotFoundException;
import com.practice.foody.mapper.DomainMapper;
import com.practice.foody.service.DbService;
import com.practice.foody.service.WeeklyRecipesCreatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/week")
@RequiredArgsConstructor
@CrossOrigin("*")

public class WeeklyRecipesController {
    private final DbService dbService;
    private final DomainMapper domainMapper;
    private final WeeklyRecipesCreatorService weeklyService;

    @PostMapping()
    public ResponseEntity<WeeklyRecipesDto> createWeeklyRecipes(@RequestParam long userId, @RequestParam LocalDate day) throws UserNotFoundException, BadQueryException {
        User user = dbService.getUser(userId);
        return ResponseEntity.ok(domainMapper.mapToWeeklyRecipesDto(weeklyService.createWeeklyRecipes(user,day)));
    }
    @GetMapping(value = "{userId}")
    public ResponseEntity<List<WeeklyRecipesDto>> getUserWeeklyRecipesList(@PathVariable long userId) throws UserNotFoundException{
        User user = dbService.getUser(userId);
        List<WeeklyRecipes> list = user.getWeeklyRecipes();
        return ResponseEntity.ok(domainMapper.mapToWeeklyRecipiesDtoList(list));

    }
    @GetMapping
    public ResponseEntity<WeeklyRecipesDto> getWeeklyRecipes(@RequestParam long weeklyId) throws NoWeeklyRecipesException {
        return ResponseEntity.ok(domainMapper.mapToWeeklyRecipesDto(dbService.getWeeklyRecipes(weeklyId)));
    }
}
