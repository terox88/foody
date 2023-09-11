package com.practice.foody.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
@Entity(name = "components")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
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
    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "INGREDIENT_ID")
    @Setter
    private  Ingredient ingredient;
    @Setter
    @ManyToOne
    @JoinColumn(name = "SECTION_ID")
    private Section section;

    public Component(Long id, int position, String text, List<Measurements> measurements, Ingredient ingredient) {
        this.id = id;
        this.position = position;
        this.text = text;
        this.measurements = measurements;
        this.ingredient = ingredient;
    }
}
