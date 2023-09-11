package com.practice.foody.repository;

import com.practice.foody.domain.Recipe;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
@Transactional
public interface RecipeRepository extends ListCrudRepository<Recipe, Long> {
    Optional<Recipe> findById(Long id);
    @Override
    Recipe save(Recipe recipe);

    @Override
    void deleteById(Long id);
}
