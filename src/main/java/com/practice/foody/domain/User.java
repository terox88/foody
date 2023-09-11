package com.practice.foody.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity (name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name =  "ID", unique = true)
    private long id;
    @Column(name = "EMAIL")
    @NotNull
    private String email;
    @Column(name = "PASSWORD")
    @NotNull
    private String password;
    @Setter
    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "PREFERENCES_ID")
    private Preferences preferences;
    @Column(name = "ROLE")
    private Role role;
    @Column(name = "CREATED")
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

    public User(String email, String password, Preferences preferences, Role role, LocalDate created, TodoisToken token) {
        this.email = email;
        this.password = password;
        this.preferences = preferences;
        this.role = role;
        this.created = created;
        this.token = token;
    }
}
