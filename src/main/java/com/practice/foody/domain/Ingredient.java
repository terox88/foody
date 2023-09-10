package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(
            targetEntity = Component.class,
            mappedBy = "ingredient",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private List<Component> components = new ArrayList<>();

    public Ingredient(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
