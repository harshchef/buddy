package com.aiknowledge.buddy.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiknowledge.buddy.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByGithubUsername(String githubUsername);

    Optional<User> findByGithubId(Long githubId);
    Optional<User> findByEmail(String email);
}
