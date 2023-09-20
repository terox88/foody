package com.practice.foody.controller;

import com.practice.foody.domain.*;
import com.practice.foody.exception.AlreadyCreatedProjectException;
import com.practice.foody.exception.UserNotFoundException;
import com.practice.foody.mapper.DomainMapper;
import com.practice.foody.mapper.TodoistApiMaper;
import com.practice.foody.service.DbService;
import com.practice.foody.service.TodoistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final DbService dbService;
    private final DomainMapper domainMapper;
    private final TodoistApiMaper todoistApiMaper;
    private final TodoistService todoistService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User user = domainMapper.mapToUser(userDto);
        return ResponseEntity.ok(domainMapper.mapToUserDto(dbService.saveUser(user)));
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> userList = dbService.getUsers();
        return ResponseEntity.ok(domainMapper.mapToUserDtoList(userList));
    }
    @GetMapping(value = "{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable long userId) throws UserNotFoundException{
        return ResponseEntity.ok(domainMapper.mapToUserDto(dbService.getUser(userId)));
    }
    @PutMapping(value = "/token")
    public ResponseEntity<Void> todoistIntegration(@RequestParam long userId, @RequestBody TodoisTokenDto todoisTokenDto)throws UserNotFoundException {
        User user = dbService.getUser(userId);
        TodoisToken token = todoistApiMaper.mapToTodoistToken(todoisTokenDto);
        user.setToken(token);
        dbService.saveUser(user);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/pref")
    public ResponseEntity<UserDto> changePreferences(@RequestParam long userId, @RequestBody PreferencesDto preferencesDto)throws UserNotFoundException {
        User user = dbService.getUser(userId);
        Preferences preferences = domainMapper.mapToPreferences(preferencesDto);
        user.getPreferences().setPreferences(preferences.getPreferences());
      return   ResponseEntity.ok(domainMapper.mapToUserDto(dbService.saveUser(user)));
    }
    @PutMapping(value = "/todoist")
    public ResponseEntity<TodoistProjectDto> createProjectForUser(@RequestParam long userId) throws UserNotFoundException, AlreadyCreatedProjectException {
        return ResponseEntity.ok(todoistService.createProject(userId));
    }
    @GetMapping(value ="/todoist" )
    public ResponseEntity<TodoistProjectDto> getUserProject(@RequestParam long userId)throws UserNotFoundException {
        User user = dbService.getUser(userId);
        return ResponseEntity.ok(todoistApiMaper.mapToTodoistProjectDto(user.getTodoistProject()));
    }
    @DeleteMapping(value = "{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable long userId) {
        dbService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
