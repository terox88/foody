package com.practice.foody.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Setter
    @ManyToOne
    @JoinColumn(name = "RECIPES_ID")
    private Recipes recipes;
}