package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity(name = "ingredients")
public class Ingredient {
    @Id
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
}
