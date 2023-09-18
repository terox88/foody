package com.practice.foody.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TodoistConfig {
    @Value("${todois.api.project.endpoint}")
    private String projectEndpoint;

    @Value("${todois.api.task.endpoint}")
    private String taskEndpoint;

}
