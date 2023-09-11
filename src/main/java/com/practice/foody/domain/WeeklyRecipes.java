package com.practice.foody.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "WEEKLY_RECIPES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class WeeklyRecipes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "BEGIN")
    private LocalDate weekBegin;
    @Column(name = "END")
    private LocalDate weekEnd;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @OneToMany(
            targetEntity = DailyRecipes.class,
            mappedBy = "weeklyRecipes",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private List<DailyRecipes> dailyRecipes = new ArrayList<>();

    public WeeklyRecipes(LocalDate weekBegin, LocalDate weekEnd, User user) {
        this.weekBegin = weekBegin;
        this.weekEnd = weekEnd;
        this.user = user;
    }
}
