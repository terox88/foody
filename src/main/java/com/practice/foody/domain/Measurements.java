package com.practice.foody.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "measurements")
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
}

