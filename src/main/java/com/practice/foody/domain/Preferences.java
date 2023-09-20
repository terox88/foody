package com.practice.foody.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "preferences")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @Setter
    @Column(name = "PREFERENCES")
    private List<UserChose> preferences = new ArrayList<>();
}
