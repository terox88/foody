package com.practice.foody.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private LocalTime created;
    @Setter
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "TOKEN_ID")
    private TodoisToken token;
    @Setter
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_ID")
    private TodoistProject todoistProject;
    @OneToMany(
            targetEntity = WeeklyRecipes.class,
            mappedBy = "user",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<WeeklyRecipes> weeklyRecipes = new ArrayList<>();

    public User(String email, String password, Preferences preferences, Role role) {
        this.email = email;
        this.password = password;
        this.preferences = preferences;
        this.role = role;
        this.created = LocalTime.now();
    }

    public User(long id, String email, String password, Preferences preferences, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.preferences = preferences;
        this.role = role;
        this.created = LocalTime.now();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(password, user.password)) return false;
        if (!Objects.equals(preferences, user.preferences)) return false;
        if (role != user.role) return false;
        if (!Objects.equals(created, user.created)) return false;
        if (!Objects.equals(token, user.token)) return false;
        return Objects.equals(weeklyRecipes, user.weeklyRecipes);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
