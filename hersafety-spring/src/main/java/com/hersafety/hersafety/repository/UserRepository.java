package com.hersafety.hersafety.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersafety.hersafety.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //Find user by username
    Optional<User> findByUsername(String name);
}
