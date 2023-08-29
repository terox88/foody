package com.practice.foody.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InstructionDto {
    private long id;
    private int position;
    private String text;
}
