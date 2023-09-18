package com.practice.foody.mapper;

import com.practice.foody.domain.TodoistProject;
import com.practice.foody.domain.TodoistProjectDto;
import com.practice.foody.domain.TodoistTask;
import com.practice.foody.domain.TodoistTaskDto;
import org.springframework.stereotype.Service;

@Service
public class TodoistApiMaper {
    public TodoistProject mapToTodoistProject(TodoistProjectDto todoistProjectDto) {
        return new TodoistProject(todoistProjectDto.getId(), todoistProjectDto.getName(),todoistProjectDto.getUrl());
    }
    public TodoistProjectDto mapToTodoistProjectDto(TodoistProject todoistProject) {
        return new TodoistProjectDto(todoistProject.getId(), todoistProject.getName(), todoistProject.getUrl());
    }
    public TodoistTask mapToTodoistTask(TodoistTaskDto todoistTaskDto) {
        return new TodoistTask(todoistTaskDto.getId(),todoistTaskDto.getContent(),todoistTaskDto.getUrl(), todoistTaskDto.getProjectId());
    }
    public TodoistTaskDto mapToTodoistTaskDto(TodoistTask todoistTask) {
        return new TodoistTaskDto(todoistTask.getId(), todoistTask.getContent(),todoistTask.getUrl(), todoistTask.getProjectId());
    }
}
