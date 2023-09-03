package com.practice.foody.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity(name = "sections")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "POSITION")
    private int position;

    private List<Component> components;
}
