package com.example.no9_progress_be.repository;

import com.example.no9_progress_be.model.auth.ERole;
import com.example.no9_progress_be.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
