package com.practice.foody.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "tokens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TodoisToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "TOKEN")
    private String token;
    @Column(name = "TYPE")
    private String type;
}
