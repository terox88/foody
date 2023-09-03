package com.practice.foody.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.List;
@Entity(name = "components")
public class Component {
    @Id
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "POSITION")
    private int position;
    @Column(name = "TEXT")
    private String text;

    private List<Measurements> measurements;

    private  Ingredient ingredient;
}
