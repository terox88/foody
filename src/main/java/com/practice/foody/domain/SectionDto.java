package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class SectionDto {
    private long id;
    private String name;
    private int position;
    private List<ComponentDto> components;

}
