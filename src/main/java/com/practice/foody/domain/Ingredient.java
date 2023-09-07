package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "ingredients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Ingredient {
    @Id
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
}
