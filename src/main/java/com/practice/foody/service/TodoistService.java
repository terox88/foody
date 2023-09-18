package com.practice.foody.service;

import com.practice.foody.client.TodoistApiClient;
import com.practice.foody.domain.*;
import com.practice.foody.exception.AlreadyCreatedProjectException;
import com.practice.foody.exception.AlreadyCreatedTaskExcepton;
import com.practice.foody.exception.CannotCreateTaskException;
import com.practice.foody.exception.UserNotFoundException;
import com.practice.foody.mapper.TodoistApiMaper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoistService {
    private final DbService dbService;
    private final TodoistApiClient todoistApiClient;
    private final TodoistApiMaper todoistApiMaper;

    public TodoistProjectDto createProject(long userId) throws UserNotFoundException, AlreadyCreatedProjectException {
        User user = dbService.getUser(userId);
        TodoistProjectDto projectDto = todoistApiClient.createProject(user);
        TodoistProject project = todoistApiMaper.mapToTodoistProject(projectDto);
        user.setTodoistProject(dbService.saveTodoistProject(project));
        dbService.saveUser(user);
        return projectDto;
    }
    public TodoistTaskDto createTask(long userId, long dailyRecipesId) throws UserNotFoundException, AlreadyCreatedTaskExcepton, CannotCreateTaskException {
        User user = dbService.getUser(userId);
        DailyRecipes dailyRecipes = dbService.getDailyRecipes(dailyRecipesId);
        TodoistTaskDto taskDto = todoistApiClient.createTask(user, dailyRecipes);
        dailyRecipes.setTodoistTask(dbService.saveTodoistTask(todoistApiMaper.mapToTodoistTask(taskDto)));
        dbService.saveDailyRecipes(dailyRecipes);
        dbService.saveUser(user);
        return taskDto;
    }
}
