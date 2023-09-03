package com.practice.foody.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "SYSTEM")
    private String system;
    @Column(name = "NAME")
    private String name;
    @Column(name = "QUANTITY")
    private String quantity;
}
