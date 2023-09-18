package com.practice.foody.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoistTaskDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("content")
    private String content;
    @JsonProperty("url")
    private String url;
    @JsonProperty("project_id")
    private String projectId;

    public TodoistTaskDto() {
    }

    public TodoistTaskDto(String content, String projectId) {
        this.content = content;
        this.projectId = projectId;
    }
}
