package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UnitDto {
    private long id;
    private String system;
    private String name;
    private String quantity;
}
