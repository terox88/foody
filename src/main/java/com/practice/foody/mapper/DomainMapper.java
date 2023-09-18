package com.practice.foody.mapper;

import com.practice.foody.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainMapper {
    private final TastyApiMapper tastyApiMapper;
    public DailyRecipesDto mapToDailyRecipesDto(DailyRecipes dailyRecipes) {
        return new DailyRecipesDto(dailyRecipes.getId(), dailyRecipes.getDay(), tastyApiMapper.mapToRecipeDtoList(dailyRecipes.getRecipes()), dailyRecipes.getShopList());
    }
    public List<DailyRecipesDto> mapToDailyRecipesDtoList(List<DailyRecipes> dailyRecipesList) {
        return dailyRecipesList.stream().map(this::mapToDailyRecipesDto).toList();
    }
    public WeeklyRecipesDto mapToWeeklyRecipesDto(WeeklyRecipes weeklyRecipes) {
        return new WeeklyRecipesDto(weeklyRecipes.getId(), weeklyRecipes.getWeekBegin(), weeklyRecipes.getWeekEnd(), mapToDailyRecipesDtoList(weeklyRecipes.getDailyRecipes()));
    }
    public PreferencesDto mapToPreferencesDto(Preferences preferences) {
        return new PreferencesDto(preferences.getId(), preferences.getPreferences());
    }
    public Preferences mapToPreferences(PreferencesDto preferencesDto){
        return new Preferences(preferencesDto.getId(), preferencesDto.getPreferences());
    }
    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getPassword(), mapToPreferencesDto(user.getPreferences()), user.getRole(), user.getCreated());
    }
    public User mapToUser(UserDto userDto) {
        return new User(userDto.getId(), userDto.getEmail(), userDto.getPassword(), mapToPreferences(userDto.getPreferences()),userDto.getRole());
    }
}
