package com.practice.foody.repository;


import com.practice.foody.domain.TodoistProject;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
@Transactional
public interface TodoistProjectRepository extends ListCrudRepository<TodoistProject, String> {
    @Override
    TodoistProject save(TodoistProject project);
    @Override
    Optional<TodoistProject> findById(String id);

}
