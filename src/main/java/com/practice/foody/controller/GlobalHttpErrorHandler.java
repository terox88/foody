package com.practice.foody.controller;

import com.practice.foody.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> alreadyCreatedProjectExceptionHandler(AlreadyCreatedProjectException exception) {
        return new ResponseEntity<>("Foody app project already exist for this user", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<Object> alreadyCreatedTaskExceptionHandler(AlreadyCreatedTaskExcepton exception) {
        return new ResponseEntity<>("Task was already created for this day", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<Object> badQueryExceptionHandler(BadQueryException exception) {
        return new ResponseEntity<>("No recipies found for given query", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<Object> cannotCreateTaskExceptionHandler(CannotCreateTaskException exception) {
        return new ResponseEntity<>("Task can't be created", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<Object> recipeNotFoundExceptionHandler(RecipeNotFoundException exception) {
        return new ResponseEntity<>("Recipe not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<Object> userNotFoundExceptionHandler(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<Object> noDailyRecipeExceptionHandler(NoDailyRecipeException exception) {
        return new ResponseEntity<>("Daily Recipes not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<Object> noWeeklyRecipeExceptionHandler(NoWeeklyRecipesException exception) {
        return new ResponseEntity<>("Weekly Recipes not found", HttpStatus.NOT_FOUND);
    }

}
