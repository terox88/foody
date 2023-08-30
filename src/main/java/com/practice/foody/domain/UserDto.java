package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class UserDto {
    private long id;
    private String login;
    private String email;
    private String password;
    private PreferencesDto preferences;
    private long week;
    private Role role;
    private LocalDate created;
    private List<WeeklyRecipesDto> weeklyRecipesDtos;



}
