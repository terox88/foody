package com.practice.foody.mapper;

import com.practice.foody.domain.*;
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
        if(todoistTaskDto == null) {
            return new TodoistTask();
        }
        return new TodoistTask(todoistTaskDto.getId(),todoistTaskDto.getContent(),todoistTaskDto.getUrl(), todoistTaskDto.getProjectId());
    }
    public TodoistTaskDto mapToTodoistTaskDto(TodoistTask todoistTask) {
        if (todoistTask == null){
            return new TodoistTaskDto();
        }
        return new TodoistTaskDto(todoistTask.getId(), todoistTask.getContent(),todoistTask.getUrl(), todoistTask.getProjectId());
    }
    public TodoisTokenDto mapToTodoistTokenDto(TodoisToken todoisToken) {
        return new TodoisTokenDto(todoisToken.getToken(),todoisToken.getType());
    }
    public TodoisToken mapToTodoistToken(TodoisTokenDto todoisTokenDto) {
        return new TodoisToken(todoisTokenDto.getToken(),todoisTokenDto.getType());
    }
}
