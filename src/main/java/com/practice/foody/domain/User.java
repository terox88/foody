package com.practice.foody.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity (name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name =  "ID", unique = true)
    private long id;
    @Column(name = "EMAIL")
    @NotNull
    private String email;
    private String password;
    @Setter
    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "PREFERENCES_ID")
    private Preferences preferences;
    private Role role;
    private LocalDate created;
    @Setter
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "TOKEN_ID")
    private TodoisToken token;
    @OneToMany(
            targetEntity = WeeklyRecipes.class,
            mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private List<WeeklyRecipes> weeklyRecipes = new ArrayList<>();

}
