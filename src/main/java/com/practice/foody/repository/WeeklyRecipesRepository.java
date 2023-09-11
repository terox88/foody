package com.practice.foody.repository;

import com.practice.foody.domain.WeeklyRecipes;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface WeeklyRecipesRepository extends ListCrudRepository<WeeklyRecipes,Long> {
    List<WeeklyRecipes> findAll();
    Optional<WeeklyRecipes> findById(long id);
    @Override
    WeeklyRecipes save(WeeklyRecipes weeklyRecipes);

    @Override
    void deleteById(Long id);
}
