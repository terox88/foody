package com.practice.foody.mapper;

import com.practice.foody.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainMapper {
    private final TodoistApiMaper todoistApiMaper;
    public DailyRecipesDto mapToDailyRecipesDto(DailyRecipes dailyRecipes) {
        List<Long> recipesId = dailyRecipes.getRecipes().stream().map(Recipe::getId).toList();
        return new DailyRecipesDto(dailyRecipes.getId(), dailyRecipes.getDay(), recipesId, todoistApiMaper.mapToTodoistTaskDto(dailyRecipes.getTodoistTask()));
    }
    public List<DailyRecipesDto> mapToDailyRecipesDtoList(List<DailyRecipes> dailyRecipesList) {
        return dailyRecipesList.stream().map(this::mapToDailyRecipesDto).toList();
    }
    public WeeklyRecipesDto mapToWeeklyRecipesDto(WeeklyRecipes weeklyRecipes) {
        List<Long> dailyRecipesId = weeklyRecipes.getDailyRecipes().stream().map(DailyRecipes::getId).toList();
        return new WeeklyRecipesDto(weeklyRecipes.getId(), weeklyRecipes.getWeekBegin(), weeklyRecipes.getWeekEnd(), dailyRecipesId);
    }
    public List<WeeklyRecipesDto> mapToWeeklyRecipiesDtoList(List<WeeklyRecipes> weeklyRecipesList) {
        return weeklyRecipesList.stream().map(this::mapToWeeklyRecipesDto).toList();
    }
    public PreferencesDto mapToPreferencesDto(Preferences preferences) {
        return new PreferencesDto(preferences.getId(), preferences.getPreferences());
    }
    public Preferences mapToPreferences(PreferencesDto preferencesDto){
        if(preferencesDto == null) {
            return new Preferences();
        }
        return new Preferences(preferencesDto.getId(), preferencesDto.getPreferences());
    }
    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getPassword(), mapToPreferencesDto(user.getPreferences()), user.getRole(), user.getCreated());
    }
    public User mapToUser(UserDto userDto) {
        return new User(userDto.getId(), userDto.getEmail(), userDto.getPassword(), mapToPreferences(userDto.getPreferences()),userDto.getRole());
    }
    public List<UserDto> mapToUserDtoList(List<User> userList) {
        return userList.stream().map(this::mapToUserDto).toList();
    }
}
