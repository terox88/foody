package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MeasurementsDto {
    private long id;
    private String quantity;
    private UnitDto unit;
}
