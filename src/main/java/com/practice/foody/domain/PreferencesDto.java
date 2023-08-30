package com.practice.foody.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PreferencesDto {
    private List<UserChose> preferences = new ArrayList<>();

}
