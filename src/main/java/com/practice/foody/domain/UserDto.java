package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class UserDto {
    private long id;
    private String email;
    private String password;
    private PreferencesDto preferences;
    private Role role;
    private LocalTime created;
    private boolean hasToken;
    private boolean hasProject;

}
