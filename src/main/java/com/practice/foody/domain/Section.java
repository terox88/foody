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
    @OneToMany(
            targetEntity = Component.class,
            mappedBy = "section",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private List<Component> components;
    @ManyToOne
    @JoinColumn(name = "RECIPES_ID")
    private Recipes recipes;
}
