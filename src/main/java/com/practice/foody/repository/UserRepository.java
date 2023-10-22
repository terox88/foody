package com.practice.foody.repository;


import com.practice.foody.domain.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends ListCrudRepository<User,Long> {
    List<User> findAll();
    Optional<User> findById(long id);
    Optional<User> findByEmailAndPassword(String email, String password);
    @Override
    User save(User user);

    @Override
    void deleteById(Long id);
}
