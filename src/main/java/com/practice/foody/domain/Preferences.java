package com.practice.foody.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "preferences")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "PREFERENCES")
    private List<UserChose> preferences = new ArrayList<>();
}
