package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstructionDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("position")
    private int position;
    @JsonProperty("display_text")
    private String text;
}
