package com.practice.foody.repository;

import com.practice.foody.domain.TodoistProject;
import com.practice.foody.domain.TodoistTask;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface TodoistTaskRepository extends ListCrudRepository<TodoistTask, String> {
    @Override
    TodoistTask save(TodoistTask task);
    @Override
    Optional<TodoistTask> findById(String id);

}
