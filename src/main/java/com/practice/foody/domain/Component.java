package com.practice.foody.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
@Entity(name = "components")
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Measurements> measurements;
    @Column(name = "INGREDIENT")
    private  String ingredient;
    @Setter
    @ManyToOne
    @JoinColumn(name = "SECTION_ID")
    private Section section;

    public Component(Long id, int position, String text, List<Measurements> measurements, String ingredient) {
        this.id = id;
        this.position = position;
        this.text = text;
        this.measurements = measurements;
        this.ingredient = ingredient;
    }
}
