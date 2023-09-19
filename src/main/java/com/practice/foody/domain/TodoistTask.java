package com.practice.foody.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "todoist_tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TodoistTask {
    @Id
    @NotNull
    @Column(name = "ID")
    private String id;
    @Column(name = "CONTENT", length = 5000)
    private String content;
    @Column(name = "TASK_URL")
    private String url;
    @Column(name = "PROJECT_ID")
    private String projectId;
}
