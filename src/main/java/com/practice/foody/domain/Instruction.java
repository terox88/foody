package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "instructions")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Instruction {
   @Id
   @NotNull
   @Column(name = "ID")
    private Long id;
    @Column(name = "POSITION")
    private int position;
    @Column(name = "TEXT")
    private String text;
}
