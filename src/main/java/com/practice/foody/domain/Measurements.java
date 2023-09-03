package com.practice.foody.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private Unit unit;
}

