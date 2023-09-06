package com.practice.foody.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;

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
    @OneToMany(
            targetEntity = Measurements.class,
            mappedBy = "component",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private List<Measurements> measurements;
    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "INGREDIENT_ID")
    private  Ingredient ingredient;
    @Setter
    @ManyToOne
    @JoinColumn(name = "SECTION_ID")
    private Section section;
}
