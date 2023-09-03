package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class UserDto {
    private long id;
    private String email;
    private String password;
    private long preferencesId;
    private Role role;
    private LocalDate created;
    private List<Long> weeklyRecipesId;



}
