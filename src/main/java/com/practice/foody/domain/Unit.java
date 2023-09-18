package com.practice.foody.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "units")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "SYS")
    private String system;
    @Column(name = "NAME")
    private String name;


    public Unit(String system, String name) {
        this.system = system;
        this.name = name;
    }
}
