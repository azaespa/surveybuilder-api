package com.azanes.surveybuilder.repo;

import com.azanes.surveybuilder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    Optional<User> findUserById(Long id);
}
