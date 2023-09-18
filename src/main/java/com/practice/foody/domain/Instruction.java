package com.practice.foody.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    @Column(name = "TEXT", length = 5000)
    private String text;
    @Setter
    @ManyToOne
    @JoinColumn(name = "RECIPES_ID")
    private Recipe recipe;

    public Instruction(Long id, int position, String text) {
        this.id = id;
        this.position = position;
        this.text = text;
    }
}
