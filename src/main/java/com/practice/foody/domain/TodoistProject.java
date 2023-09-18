package com.practice.foody.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "todoist_projects")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TodoistProject {
    @Id
    @NotNull
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PROJECT_URL")
    private String url;



}
