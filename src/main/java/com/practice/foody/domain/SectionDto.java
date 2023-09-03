package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SectionDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("position")
    private int position;
    @JsonProperty("components")
    private List<ComponentDto> components;

}
