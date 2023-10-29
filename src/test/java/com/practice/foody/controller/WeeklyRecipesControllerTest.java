package com.practice.foody.controller;

import com.practice.foody.domain.*;
import com.practice.foody.mapper.DomainMapper;
import com.practice.foody.service.DbService;
import com.practice.foody.service.WeeklyRecipesCreatorService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(WeeklyRecipesController.class)
public class WeeklyRecipesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WeeklyRecipesCreatorService weeklyService;
    @MockBean
    private DomainMapper domainMapper;
    @MockBean
    private DbService dbService;
    private WeeklyRecipes weeklyRecipes;
    private WeeklyRecipesDto weeklyRecipesDto;
    private User user;

    @BeforeEach
    void preparingData() {
        Preferences preferences = new Preferences();
        preferences.getPreferences().add(UserChose.LOW_CALORIE);
        user = new User("test email", "password", preferences,Role.USER);
        List<DailyRecipes> dailyRecipesList = new ArrayList<>();
        for(int d = 0; d < 7; d++) {
            List<Recipe> recipes = new ArrayList<>();
            for (int r = 0; r < 4; r++) {
                Instruction instruction = new Instruction(Long.valueOf(r+d),r,"Test"+r);
                List<Instruction> instructions = Arrays.asList(instruction);
                Unit unit = new Unit("Testing system" + r, "gram");
                Measurements measurements = new Measurements(Long.valueOf(r+d),"12." + r, unit);
                List<Measurements> measurementsList = Arrays.asList(measurements);
                Component component = new Component(Long.valueOf(r+d),r, "test component" + r, measurementsList, "test" + r);
                List<Component> components = Arrays.asList(component);
                Section section = new Section("",1, components);
                List<Section> sections = Arrays.asList(section);
                Nutrition nutrition = new Nutrition(r+1,r+2,r+3,r+4,r+5,r+6);
                Recipe recipe = new Recipe(Long.valueOf(r+d),"test recipe"+ r, "test" + r, MealType.BREAKFAST, instructions, sections, nutrition);
                recipes.add(recipe);
            }
            dailyRecipesList.add(new DailyRecipes(Long.valueOf(d), LocalDate.now().plusDays(d),recipes, weeklyRecipes, null));
        }
        weeklyRecipes = new WeeklyRecipes(1L, LocalDate.now(),LocalDate.now().plusDays(7), user, dailyRecipesList);
        weeklyRecipesDto = new WeeklyRecipesDto(weeklyRecipes.getId(), weeklyRecipes.getWeekBegin(), weeklyRecipes.getWeekEnd(), weeklyRecipes.getDailyRecipes().stream().map(DailyRecipes::getId).toList());
    }

    @Test
    void shouldCreateWeeklyRecipes() throws Exception {
        //Given
        when(dbService.getUser(anyLong())).thenReturn(user);
        when(weeklyService.createWeeklyRecipes(any(User.class), any(LocalDate.class))).thenReturn(weeklyRecipes);
        when(domainMapper.mapToWeeklyRecipesDto(weeklyRecipes)).thenReturn(weeklyRecipesDto);
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/week")
                        .param("userId", "12")
                        .param("day", LocalDate.now().toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.dailyRecipesId", Matchers.hasSize(7)));
    }
    @Test
    void shouldGetWeeklyRecipes() throws Exception {
        //Given
        when(dbService.getWeeklyRecipes(anyLong())).thenReturn(weeklyRecipes);
        when(domainMapper.mapToWeeklyRecipesDto(weeklyRecipes)).thenReturn(weeklyRecipesDto);
        //When&Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/week")
                .param("weeklyId", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void shouldGetUsersWeeklyRecipes() throws Exception {
       //Given
       List<WeeklyRecipesDto> weeklyRecipesDtoList = List.of(weeklyRecipesDto);
        when(dbService.getUser(anyLong())).thenReturn(user);
        when(domainMapper.mapToWeeklyRecipiesDtoList(anyList())).thenReturn(weeklyRecipesDtoList);
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/week/"+user.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
    }

}
