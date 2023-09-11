package com.practice.foody.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity(name = "measurements")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Measurements {
    @Id
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "QUANTITY")
    private String quantity;
    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "UNIT_ID")
    private Unit unit;
    @Setter
    @ManyToOne
    @JoinColumn(name = "COMPONENT_ID")
    private Component component;

    public Measurements(Long id, String quantity, Unit unit) {
        this.id = id;
        this.quantity = quantity;
        this.unit = unit;
    }
}

