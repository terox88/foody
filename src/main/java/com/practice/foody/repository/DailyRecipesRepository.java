package com.practice.foody.repository;

import com.practice.foody.domain.DailyRecipes;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DailyRecipesRepository extends ListCrudRepository<DailyRecipes, Long> {
    List<DailyRecipes> findAll();
    Optional<DailyRecipes> findById(long id);
    @Override
    DailyRecipes save(DailyRecipes dailyRecipes);

    @Override
    void deleteById(Long id);
}
