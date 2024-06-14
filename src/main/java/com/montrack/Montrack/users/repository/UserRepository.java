package com.montrack.Montrack.users.repository;

import com.montrack.Montrack.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Users> findByUsername(String username);
    boolean existsByUsername(String username);
}