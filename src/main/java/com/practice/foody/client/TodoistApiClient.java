package com.practice.foody.client;

import com.practice.foody.config.TodoistConfig;
import com.practice.foody.domain.DailyRecipes;
import com.practice.foody.domain.TodoistProjectDto;
import com.practice.foody.domain.TodoistTaskDto;
import com.practice.foody.domain.User;
import com.practice.foody.exception.AlreadyCreatedProjectException;
import com.practice.foody.exception.AlreadyCreatedTaskExcepton;
import com.practice.foody.exception.CannotCreateTaskException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TodoistApiClient {
    private final RestTemplate restTemplate;
    private final TodoistConfig todoistConfig;

    public TodoistProjectDto createProject(User user) throws AlreadyCreatedProjectException{
        if (user.getTodoistProject() != null) {
            throw new AlreadyCreatedProjectException();
        }
        HttpHeaders headers = createHeaders(user);
        TodoistProjectDto project = new TodoistProjectDto("Foody app shopping list");
        HttpEntity <TodoistProjectDto> entity = new HttpEntity<>(project, headers);
        ResponseEntity<TodoistProjectDto> response = restTemplate.exchange(todoistConfig.getProjectEndpoint(), HttpMethod.POST, entity, TodoistProjectDto.class);
        return response.getBody();

    }

    public TodoistTaskDto createTask(User user, DailyRecipes dailyRecipes) throws AlreadyCreatedTaskExcepton, CannotCreateTaskException{
        if(dailyRecipes.getTodoistTask() != null) {
            throw  new AlreadyCreatedTaskExcepton();
        }
       boolean isTaskForUser = user.getWeeklyRecipes().stream().flatMap(weeklyRecipes -> weeklyRecipes.getDailyRecipes().stream())
                .map(id -> id.getId()).anyMatch(id -> id == dailyRecipes.getId());
        if(!isTaskForUser) {
            throw new CannotCreateTaskException();
        }
        HttpHeaders headers = createHeaders(user);
        TodoistTaskDto task = new TodoistTaskDto(dailyRecipes.getShopList(), user.getTodoistProject().getId());
        HttpEntity <TodoistTaskDto> entity = new HttpEntity<>(task, headers);
        ResponseEntity<TodoistTaskDto> response = restTemplate.exchange(todoistConfig.getTaskEndpoint(), HttpMethod.POST, entity, TodoistTaskDto.class);
        return response.getBody();

    }

    public HttpHeaders createHeaders(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", user.getToken().toString());
        return headers;
    }

}

